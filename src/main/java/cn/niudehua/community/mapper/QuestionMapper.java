package cn.niudehua.community.mapper;

import cn.niudehua.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: deng
 * @datetime: 2020/4/27 4:33 下午
 * @desc:
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_creat, gmt_modified, creator, comment_count, view_count, like_count, tag) values( #{title},#{ description},#{ gmtCreat},#{ gmtModified},#{ creator},#{ commentCount},#{ viewCount},#{ likeCount},#{ tag})  ")
    void insert(Question question);

}
