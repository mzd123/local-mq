package localmq.interfaces.dto.http;

import localmq.interfaces.dto.BaseDTO;
import lombok.Data;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 4:36 下午
 */
@Data
public class HttpRespDTO<T> extends BaseDTO {
    private boolean success;
    private T data;
    private String errMsg;
    private String errCode;
    private Page page;
}
