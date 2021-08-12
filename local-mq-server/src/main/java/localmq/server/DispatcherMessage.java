package localmq.server;

import localmq.interfaces.constant.ResultConstant;
import localmq.interfaces.dto.http.HttpRespDTO;
import localmq.interfaces.dto.resp.MessageRespDTO;
import localmq.interfaces.enums.MessageTypeEnum;
import localmq.interfaces.utils.HttpRespDTOUtils;
import localmq.server.service.message.MessageStoreStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:12 下午
 */
@Component
@Order
public class DispatcherMessage {

    @Autowired
    private ApplicationContext applicationContext;

    HashMap<String, MessageStoreStrategy> hashMap = new HashMap<>();

    @PostConstruct
    public void init() {
        String names[] = applicationContext.getBeanNamesForType(MessageStoreStrategy.class);
        for (String name : names) {
            MessageStoreStrategy messageStoreStrategy = (MessageStoreStrategy) applicationContext.getBean(name);
            hashMap.put(name, messageStoreStrategy);
        }
    }

    /**
     * 转发分配
     *
     * @param messageRespDTO
     * @return
     */
    public HttpRespDTO<MessageRespDTO> storeMessage(MessageRespDTO messageRespDTO) {
        if (StringUtils.isBlank(messageRespDTO.getMessageId())
                || StringUtils.isBlank(messageRespDTO.getGroup())
                || StringUtils.isBlank(messageRespDTO.getTopic())
                || StringUtils.isBlank(messageRespDTO.getSendTime())
                || StringUtils.isBlank(messageRespDTO.getMessageType())) {
            return HttpRespDTOUtils.failure(ResultConstant.PARAM_NULL_CODE, ResultConstant.PARAM_NULL_MSG + "messageType");
        }
        MessageTypeEnum messageTypeEnum = MessageTypeEnum.getEnum(messageRespDTO.getMessageType());
        if (messageTypeEnum == null) {
            return HttpRespDTOUtils.failure(ResultConstant.PARAM_NULL_CODE, ResultConstant.PARAM_ENUM_ERROR_MSG + "messageType");
        }
        return hashMap.get(messageTypeEnum.getServiceName()).storeMessage(messageRespDTO);
    }
}
