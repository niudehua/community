package cn.niudehua.community.exception;

/**
 * @author: deng
 * @datetime: 2020/5/2 10:44 上午
 * @desc: 定制错误码枚举
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    /**
     * 问题不存在
     */
    QUESTION_NOT_FOUNT("你找的这个问题不在了，换个其它的试试吧！！！");
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
