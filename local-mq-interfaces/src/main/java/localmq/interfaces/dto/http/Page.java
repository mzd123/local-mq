package localmq.interfaces.dto.http;

import localmq.interfaces.dto.BaseDTO;
import lombok.Data;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 4:38 下午
 */
@Data
public class Page extends BaseDTO {
    private int pageNum;
    private int pageSize;
    private int totalPages;
    private int total;
}
