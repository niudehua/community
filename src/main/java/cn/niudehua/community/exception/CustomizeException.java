package cn.niudehua.community.exception;

/**
 * @author: deng
 * @datetime: 2020/5/2 10:40 上午
 * @desc: 定制异常
 */
public class CustomizeException extends RuntimeException {
    private final String message;

    public CustomizeException(ICustomizeErrorCode customizeErrorCode) {
        message = customizeErrorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
