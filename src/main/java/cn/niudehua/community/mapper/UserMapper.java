package cn.niudehua.community.mapper;

import cn.niudehua.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: deng
 * @datetime: 2020/4/27 9:41 上午
 * @desc: 用户模型映射
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

    /**
     * 通过id查找用户
     *
     * @param id User id
     * @return user
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 通过accountId查找用户
     *
     * @param accountId 账户名
     * @return user
     */
    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    /**
     * 更新user
     *
     * @param user user
     */
    @Update("update user set name=#{user.name},token=#{user.token},gmt_modified=#{user.gmtModified},bio=#{user.bio},avatar_url=#{user.avatarUrl} where id =#{user.id}" )
    void update(@Param("user") User user);
}
