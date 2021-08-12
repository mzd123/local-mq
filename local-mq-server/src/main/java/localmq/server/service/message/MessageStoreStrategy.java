package localmq.server.service.message;

import localmq.interfaces.dto.http.HttpRespDTO;
import localmq.interfaces.dto.resp.MessageRespDTO;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:57 下午
 */
public interface MessageStoreStrategy {

    HttpRespDTO<MessageRespDTO> storeMessage(MessageRespDTO messageRespDTO);
}
