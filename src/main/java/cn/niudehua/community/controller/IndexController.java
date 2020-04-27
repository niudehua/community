package cn.niudehua.community.controller;

import cn.niudehua.community.dto.QuestionDTO;
import cn.niudehua.community.mapper.QuestionMapper;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.Question;
import cn.niudehua.community.model.User;
import cn.niudehua.community.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/4/26 2:52 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexController {
    private final UserMapper userMapper;
    private final QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest
            , Model model) {
        User userMapperByToken = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    userMapperByToken = userMapper.findByToken(cookie.getValue());
                    if (userMapperByToken != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", userMapperByToken);
                    }
                    break;
                }
            }
            List<QuestionDTO> questionList = questionService.list();
            model.addAttribute("questions", questionList);
        }

        return "index";
    }


}

