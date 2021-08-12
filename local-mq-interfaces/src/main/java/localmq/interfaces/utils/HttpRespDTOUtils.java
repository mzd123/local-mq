package localmq.interfaces.utils;

import localmq.interfaces.dto.http.HttpRespDTO;
import localmq.interfaces.dto.http.Page;

/**
 * @Author mazhoudi
 * @Date 2021/8/11 5:17 下午
 */
public class HttpRespDTOUtils {


    public static <T> HttpRespDTO<T> success() {
        return success(null, null);
    }

    public static <T> HttpRespDTO<T> success(T data) {
        return success(data, null);
    }

    public static <T> HttpRespDTO<T> success(T data, Page page) {
        HttpRespDTO httpRespDTO = new HttpRespDTO();
        httpRespDTO.setData(data);
        httpRespDTO.setPage(page);
        httpRespDTO.setSuccess(true);
        return httpRespDTO;
    }


    public static <T> HttpRespDTO<T> failure(String errCode, String errMsg) {
        HttpRespDTO httpRespDTO = new HttpRespDTO();
        httpRespDTO.setErrCode(errCode);
        httpRespDTO.setErrMsg(errMsg);
        httpRespDTO.setSuccess(false);
        return httpRespDTO;
    }
}
