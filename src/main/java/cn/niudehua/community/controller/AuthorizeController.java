package cn.niudehua.community.controller;

import cn.niudehua.community.dto.AccessTokenDTO;
import cn.niudehua.community.dto.GitHubUser;
import cn.niudehua.community.model.User;
import cn.niudehua.community.provider.GithubProvider;
import cn.niudehua.community.service.UserService;
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
 * @desc: github授权控制
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizeController {
    private final GithubProvider githubProvider;
    private final UserService userService;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    /**
     * github鉴权回调 获取gitHubUser信息存放数据库
     *
     * @param code                The code you received as a response to Step 1
     * @param state               The unguessable random string you provided in Step 1
     * @param httpServletResponse httpServletResponse
     * @return 重定向到首页
     */
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
        //获取 accessToken
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //获取gitHub User信息
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
            user.setAvatarUrl(gitHubUser.getAvatarUrl());
            userService.updateOrCreateUser(user);
            httpServletResponse.addCookie(new Cookie("token", token));
        }
        return "redirect:/";
    }

    /**
     * 用户登出
     *
     * @param httpServletRequest  httpServletRequest
     * @param httpServletResponse httpServletResponse
     * @return 重定向到首页
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        // 清除session
        httpServletRequest.getSession().removeAttribute("gitHubUser");
        // 清除token
        Cookie emptyToken = new Cookie("token", null);
        emptyToken.setMaxAge(0);
        httpServletResponse.addCookie(emptyToken);
        return "redirect:/";
    }
}
