package cn.niudehua.community.mapper;

import cn.niudehua.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: deng
 * @datetime: 2020/4/27 9:41 上午
 * @desc:
 */
@Mapper
public interface UserMapper {
    /**
     * 新增用户信息
     *
     * @return user
     */
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified) values (#{name} ,#{accountId},#{token},#{gmtCreat},#{gmtModified}) ")
    void insert(User user);
}
