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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: deng
 * @datetime: 2020/4/30 1:40 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ProfileController {
    private final UserMapper userMapper;
    private final QuestionService questionService;

    /**
     * 个人资料
     *
     * @param action             个人资料下拉分栏
     * @param page               当前页
     * @param size               每页数据条数
     * @param model              视图模型
     * @param httpServletRequest http Servlet请求
     * @return 个人资料页
     */
    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable(name = "action") String action,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "3") Integer size,
            Model model,
            HttpServletRequest httpServletRequest) {
        User user = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (!ObjectUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                // 通过cookie获取用户信息并将用户信息保存到session
                if ("token".equals(cookie.getName())) {
                    user = userMapper.findByToken(cookie.getValue());
                    if (user != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", user);
                    }
                    break;
                }
            }
        }

        if (ObjectUtils.isEmpty(user)) {
            return "redirect:/";
        }
        //个人资料下拉分栏
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("paginationDTO", paginationDTO);
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        return "/profile";
    }
}
