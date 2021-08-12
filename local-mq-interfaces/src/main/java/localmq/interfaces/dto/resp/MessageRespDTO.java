package localmq.interfaces.dto.resp;


import localmq.interfaces.dto.req.MessageReqDTO;
import lombok.Data;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 3:54 下午
 */
@Data
public class MessageRespDTO extends MessageReqDTO {
    /**
     * 存储时间
     */
    private String storeTime;
    /**
     * 消费时间
     */
    private String consumerTime;
}
