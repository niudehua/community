package cn.niudehua.community.service;

import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author: deng
 * @datetime: 2020/5/1 5:05 下午
 * @desc: 用户服务
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    /**
     * 更新或创建User
     *
     * @param user user
     */
    public void updateOrCreateUser(User user) {
        //通过accountId 查询 数据库
        User userDb = userMapper.findByAccountId(user.getAccountId());
        if (!ObjectUtils.isEmpty(userDb)) {
            // 如果有更新
            userDb.setToken(user.getToken());
            userDb.setGmtModified(System.currentTimeMillis());
            userDb.setAvatarUrl(user.getAvatarUrl());
            userDb.setBio(user.getBio());
            userDb.setName(user.getName());
            userMapper.update(userDb);
        } else {
            // 如果没有新增
            user.setGmtModified(System.currentTimeMillis());
            userMapper.insert(user);
        }
    }
}
