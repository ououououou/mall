package huixuan.ou.mall.common.api;

/**
 * @program: mall
 * @description:
 * @author: ouhuixuan
 * @create: 2019-11-26 09:06
 **/
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @Description: 成功返回数据
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/26
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * @Description: 成功返回结果，自定义成功提示信息
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * @Description: 失败返回结果
     * @Param: errorCode 错误码
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * @Description: 失败返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * @Description: 失败返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * @Description: 参数验证失败返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * @Description:c参数验证失败返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * @Description: 未登录返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * @Description: 未授权返回结果
     * @Param:
     * @return:
     * @Author: ouhuixuan
     * @Date: 2019/11/27
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
