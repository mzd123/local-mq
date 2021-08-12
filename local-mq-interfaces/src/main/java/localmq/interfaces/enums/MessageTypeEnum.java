package localmq.interfaces.enums;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:30 下午
 */
public enum MessageTypeEnum {

    PUBLIC_MESSAGE("1", "普通消息", "publicMessageStoreStrategy"),
    ORDER_MESSAGE("2", "顺序消息", "orderMessageStoreStrategy"),
    DELAY_MESSAGE("3", "延迟消息", "delayMessageStoreStrategy"),
    TRANSACTIONAL_MESSAGE("4", "事务消息", "transactionalMessageStoreStrategy");

    /**
     * 1 普通消息
     * 2 顺序消息
     * 3 延迟消息
     * 4 事务消息
     */

    private String code;

    private String desc;

    private String serviceName;

    MessageTypeEnum(String code, String desc, String serviceName) {
        this.code = code;
        this.desc = desc;
        this.serviceName = serviceName;
    }

    public static MessageTypeEnum getEnum(String code) {
        for (MessageTypeEnum messageTypeEnum : values()) {
            if (messageTypeEnum.getCode().equals(code)) {
                return messageTypeEnum;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
