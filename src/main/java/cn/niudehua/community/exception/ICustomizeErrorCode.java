package cn.niudehua.community.exception;

/**
 * @author: deng
 * @datetime: 2020/5/2 10:43 上午
 * @desc: 定制错误码
 */
public interface ICustomizeErrorCode {
    /**
     * 获取错误码
     * @return ErrorCode
     */
    Integer getCode();

    /**
     * 获取错误信息
     *
     * @return ErrorMessage
     */
    String getMessage();
}
