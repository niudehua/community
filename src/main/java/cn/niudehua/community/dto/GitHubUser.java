package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 12:47 上午
 * @desc: gitHub用户信息
 */
@Data
public class GitHubUser {
    /**
     * 用户名
     */
    private String name;
    /**
     * id
     */
    private Long id;
    /**
     * 个人经历
     */
    private String bio;
    /**
     * 网络头像
     */
    private String avatarUrl;
}
