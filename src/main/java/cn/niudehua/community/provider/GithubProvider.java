package cn.niudehua.community.provider;

import cn.niudehua.community.dto.AccessTokenDTO;
import cn.niudehua.community.dto.GitHubUser;
import cn.niudehua.community.exception.CustomizeErrorCode;
import cn.niudehua.community.exception.CustomizeException;
import cn.niudehua.community.exception.ICustomizeErrorCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * @author: deng
 * @datetime: 2020/4/27 12:06 上午
 * @desc: GitHub提供者
 */
@Component
public class GithubProvider {

    /**
     * 获取gitHub AccessToken
     *
     * @param accessTokenDTO GitHub授权
     * @return AccessToken
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = Objects.requireNonNull(response.body()).string();
            String accessToken = JSONObject.parseObject(string).getString("access_token");
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取gitHub用户信息
     *
     * @param token AccessToken
     * @return GitHubUser
     */
    public GitHubUser getGitHubUser(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user").addHeader("Authorization", "token " + token)
                .build();

        String string = null;
        try {
            Response response = client.newCall(request).execute();
            string = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.SYS_ERROR);
        }
        return JSON.parseObject(string, GitHubUser.class);

    }
}

