package cn.niudehua.community.mapper;

import cn.niudehua.community.model.Question;
import cn.niudehua.community.model.QuestionExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {

    /**
     * 增加问题浏览数
     *
     * @param record question
     */
    void incViewCount(Question record);

    /**
     * 增加评论数
     *
     * @param question question
     */
    void incCommentCount(Question question);

    List<Question> selectByExampleWithRowbounds(QuestionExample questionExample, RowBounds rowBounds);
}