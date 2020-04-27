package cn.niudehua.community.mapper;

import cn.niudehua.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: deng
 * @datetime: 2020/4/27 9:41 上午
 * @desc:
 */
@Mapper
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user 用户信息
     */
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified,bio,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);

    /**
     * 通过token查找用户
     *
     * @param token token
     * @return user
     */
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
