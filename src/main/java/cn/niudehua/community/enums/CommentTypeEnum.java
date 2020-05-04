package cn.niudehua.community.enums;

/**
 * @author: deng
 * @datetime: 2020/5/3 11:57 上午
 * @desc:
 */
public enum CommentTypeEnum {
    /**
     * 问题的回复
     */
    QUESTION(1),
    /**
     * 评论的回复
     */
    COMMENT(2);
    private final Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
