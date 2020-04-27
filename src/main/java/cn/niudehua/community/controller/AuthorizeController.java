package cn.niudehua.community.controller;

import cn.niudehua.community.dto.AccessTokenDTO;
import cn.niudehua.community.dto.GitHubUser;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.User;
import cn.niudehua.community.provider.GithubProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author: deng
 * @datetime: 2020/4/26 11:39 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizeController {

    private final GithubProvider githubProvider;

    private final UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse httpServletResponse) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = githubProvider.getGitHubUser(accessToken);
        if (gitHubUser != null) {
            //登录成功 写入cookie和session
            User user = new User();
            user.setName(gitHubUser.getName());
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setBio(gitHubUser.getBio());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreat(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreat());
            userMapper.insert(user);
            httpServletResponse.addCookie(new Cookie("token", token));
        }

        //登录失败，重新登录
        return "redirect:/";

    }


}
