package cn.niudehua.community.model;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 9:34 上午
 * @desc: 用户模型
 */
@Data
public class User {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 账户名
     */
    private String accountId;
    /**
     * 登录token
     */
    private String token;
    /**
     * 创建时间
     */
    private Long gmtCreat;
    /**
     * 修改时间
     */
    private Long gmtModified;
    /**
     * 个人经历
     */
    private String bio;
    /**
     * 网络头像
     */
    private String avatarUrl;
}
