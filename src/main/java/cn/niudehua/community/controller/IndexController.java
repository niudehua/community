package cn.niudehua.community.controller;

import cn.niudehua.community.dto.PaginationDTO;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.User;
import cn.niudehua.community.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
     * @param page               当前页
     * @param size               每页数据条数
     * @return 主页
     */
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest, Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "3") Integer size) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                // 通过cookie获取用户信息并将用户信息保存到session
                if ("token".equals(cookie.getName())) {
                    User user = userMapper.findByToken(cookie.getValue());
                    if (user != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", user);
                    }
                    break;
                }
            }
        }
        //获取问题列表
        PaginationDTO paginationDTO = questionService.list(page, size);
        model.addAttribute("paginationDTO", paginationDTO);
        return "index";
    }


}

