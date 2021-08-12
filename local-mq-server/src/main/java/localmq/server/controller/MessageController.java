package localmq.server.controller;


import com.alibaba.fastjson.JSON;
import localmq.interfaces.constant.ResultConstant;
import localmq.interfaces.constant.UrlConstant;
import localmq.interfaces.dto.http.HttpRespDTO;
import localmq.interfaces.dto.req.MessageReqDTO;
import localmq.interfaces.dto.resp.MessageRespDTO;
import localmq.interfaces.utils.HttpRespDTOUtils;
import localmq.server.DispatcherMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 4:32 下午
 */
@RestController
@Slf4j
public class MessageController {

    @Resource
    private DispatcherMessage dispatcherMessage;

    @RequestMapping(UrlConstant.MESSAGE_SEND_URL)
    public HttpRespDTO<MessageRespDTO> sendMessage(@RequestBody MessageReqDTO messageReqDTO) {
        log.info("收到消息：{}", JSON.toJSONString(messageReqDTO));
        HttpRespDTO<MessageRespDTO> result = new HttpRespDTO<>();
        MessageRespDTO messageRespDTO = JSON.parseObject(JSON.toJSONString(messageReqDTO), MessageRespDTO.class);
        try {
            //messageRespDTO.setStoreTime(new SimpleDateFormat(CommonConstant.DATE_TIME_FORMAT),new Date());
            result = dispatcherMessage.storeMessage(messageRespDTO);
        } catch (Exception e) {
            log.error("存储消息失败:", e);
            result = HttpRespDTOUtils.failure(ResultConstant.SYSTEM_ERROR_CODE, ResultConstant.SYSTEM_ERROR_MSG);
        }
        return result;
    }
}
