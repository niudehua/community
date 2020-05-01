package cn.niudehua.community.service;

import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.User;
import cn.niudehua.community.model.UserExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
        UserExample example = new UserExample();
        example.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(users)) {
            // 如果没有新增
            user.setGmtModified(System.currentTimeMillis());
            userMapper.insert(user);

        } else {
            // 如果有更新
            // 创建时间不更新
            user.setGmtModified(users.get(0).getGmtCreat());
            user.setId(users.get(0).getId());
            userMapper.updateByPrimaryKeySelective(user);
        }
    }
}
