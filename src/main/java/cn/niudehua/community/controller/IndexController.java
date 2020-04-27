package cn.niudehua.community.controller;

import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: deng
 * @datetime: 2020/4/26 2:52 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexController {
    private final UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    User userMapperByToken = userMapper.findByToken(cookie.getValue());
                    if (userMapperByToken != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", userMapperByToken);
                    }
                    break;
                }
            }
        }
        return "index";
    }


}

