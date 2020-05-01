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
 * @desc:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    public void updateOrCreateUser(User user) {
        User userDb = userMapper.findByAccountId(user.getAccountId());
        if (!ObjectUtils.isEmpty(userDb)) {
            userDb.setToken(user.getToken());
            userDb.setGmtModified(System.currentTimeMillis());
            userDb.setAvatarUrl(user.getAvatarUrl());
            userDb.setBio(user.getBio());
            userDb.setName(user.getName());
            userMapper.update(userDb);
        } else {
            user.setGmtModified(System.currentTimeMillis());
            userMapper.insert(user);
        }
    }
}
