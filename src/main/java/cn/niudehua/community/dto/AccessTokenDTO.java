package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 12:08 上午
 * @desc: GitHub授权
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
