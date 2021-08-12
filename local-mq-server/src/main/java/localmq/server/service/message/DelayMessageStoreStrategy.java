package localmq.server.service.message;

import localmq.interfaces.dto.http.HttpRespDTO;
import localmq.interfaces.dto.resp.MessageRespDTO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:09 下午
 */
@Service
@Order(-1)
public class DelayMessageStoreStrategy implements MessageStoreStrategy {
    @Override
    public HttpRespDTO<MessageRespDTO> storeMessage(MessageRespDTO messageRespDTO) {
        return null;
    }
}
