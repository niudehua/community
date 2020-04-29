package cn.niudehua.community.mapper;

import cn.niudehua.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/4/27 4:33 下午
 * @desc: 问题模型映射
 */
@Mapper
public interface QuestionMapper {
    /**
     * 新增问题
     *
     * @param question 问题模型
     */
    @Insert("insert into question (title, description, gmt_creat, gmt_modified, creator, comment_count, view_count, like_count, tag) values( #{title},#{ description},#{ gmtCreat},#{ gmtModified},#{ creator},#{ commentCount},#{ viewCount},#{ likeCount},#{ tag})  ")
    void insert(Question question);

    /**
     * 查询所有问题
     *
     * @param offset
     * @param size
     * @return List<Question>
     */
    @Select("select * from question limit #{offset},#{size} ")
    List<Question> list(@Param("offset") Integer offset,
                        @Param("size") Integer size);

    /**
     * 查询总条数
     *
     * @return totalCount
     */
    @Select("select count(1) from question")
    Integer count();
}