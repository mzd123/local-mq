package localmq.interfaces.dto.req;


import localmq.interfaces.dto.BaseDTO;
import localmq.interfaces.enums.MessageTypeEnum;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 3:43 下午
 */
@Data
public class MessageReqDTO extends BaseDTO {
    /**
     * 消息id
     */
    private String messageId;
    /**
     * 分组
     */
    private String group;
    /**
     * 主题
     */
    private String topic;
    /**
     * 标签
     */
    private String tag;
    /**
     * 发送时间
     */
    private String sendTime;
    /**
     * @see MessageTypeEnum
     */
    private String messageType;
    /**
     * 延迟时间
     */
    private Long delayTime;
    /**
     * 延迟时间单位
     */
    private TimeUnit delayTimeUnit;
}
