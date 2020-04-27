package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 12:47 上午
 * @desc:
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
