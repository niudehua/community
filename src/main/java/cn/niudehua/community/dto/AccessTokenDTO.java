package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 12:08 上午
 * @desc: GitHub授权 .
 */
@Data
public class AccessTokenDTO {
    /**
     * The client ID you received from GitHub for your GitHub App.
     */
    private String client_id;
    /**
     * The client secret you received from GitHub for your GitHub App.
     */
    private String client_secret;
    /**
     * The code you received as a response to Step 1.
     */
    private String code;
    /**
     * Authorization callback URL
     */
    private String redirect_uri;
    /**
     * The unguessable random string you provided in Step 1.
     */
    private String state;
}
