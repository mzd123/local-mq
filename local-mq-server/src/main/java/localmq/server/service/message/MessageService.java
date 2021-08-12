package localmq.server.service.message;


import localmq.interfaces.dto.resp.MessageRespDTO;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:05 下午
 */
public abstract class MessageService {

    public MessageStoreStrategy messageStoreStrategy;

    public MessageRespDTO storeMessage(MessageRespDTO messageRespDTO) {
        return messageStoreStrategy.storeMessage(messageRespDTO);
    }
}
