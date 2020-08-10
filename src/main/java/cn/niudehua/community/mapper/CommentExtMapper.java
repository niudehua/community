package cn.niudehua.community.mapper;

import cn.niudehua.community.model.Comment;

public interface CommentExtMapper {
    /**
     * 增加评论的回复数
     *
     * @param parentComment parentComment
     */
    void incCommentCount(Comment parentComment);
}