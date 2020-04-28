package cn.niudehua.community.controller;

import cn.niudehua.community.mapper.QuestionMapper;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.Question;
import cn.niudehua.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: deng
 * @datetime: 2020/4/27 2:01 下午
 * @desc: 问题发布控制
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishController {
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;

    /**
     * 问题发布
     *
     * @return 发布页面
     */
    @GetMapping(value = "/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 编辑发布问题
     *
     * @param title              问题标题
     * @param description        问题补充，问题描述
     * @param tag                标签
     * @param httpServletRequest http Servlet请求
     * @param model              视图模型
     * @return 发布页面
     */
    @PostMapping(value = "/publish")
    public String doPublish(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "tag") String tag,
            HttpServletRequest httpServletRequest,
            Model model
    ) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        // 非空判断
        if (StringUtils.isEmpty(title)) {
            model.addAttribute("error", "问题标题不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(description)) {
            model.addAttribute("error", "问题补充，问题描述不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(tag)) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

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
        // 用户未登录，跳转回发布页面
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        // 储存发布的问题并重定向到index页面
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setGmtCreat(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreat());
        question.setCreator(user.getId());
        question.setTag(tag);
        questionMapper.insert(question);
        return "redirect:/";
    }
}