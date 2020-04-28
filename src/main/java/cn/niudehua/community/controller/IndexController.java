package cn.niudehua.community.controller;

import cn.niudehua.community.dto.QuestionDTO;
import cn.niudehua.community.mapper.UserMapper;
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
 * @desc: 主页控制
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexController {
    private final UserMapper userMapper;
    private final QuestionService questionService;

    /**
     * 主页
     *
     * @param httpServletRequest http Servlet请求
     * @param model              视图模型
     * @return 主页
     */
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest
            , Model model) {
        User userMapperByToken;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                // 通过cookie获取用户信息并将用户信息保存到session
                if ("token".equals(cookie.getName())) {
                    userMapperByToken = userMapper.findByToken(cookie.getValue());
                    if (userMapperByToken != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", userMapperByToken);
                    }
                    break;
                }
            }
            //获取问题列表
            List<QuestionDTO> questionList = questionService.list();
            model.addAttribute("questions", questionList);
        }

        return "index";
    }


}

