package cn.niudehua.community.mapper;

import cn.niudehua.community.model.Comment;
import cn.niudehua.community.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    /**
     * 增加评论的回复数
     *
     * @param parentComment parentComment
     */
    void incCommentCount(Comment parentComment);
}