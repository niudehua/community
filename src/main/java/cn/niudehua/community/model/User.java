package cn.niudehua.community.model;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 9:34 上午
 * @desc:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private String bio;
    private String avatarUrl;
}
