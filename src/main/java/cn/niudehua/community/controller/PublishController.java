package cn.niudehua.community.controller;

import cn.niudehua.community.mapper.QuestionMapper;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.Question;
import cn.niudehua.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: deng
 * @datetime: 2020/4/27 2:01 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishController {
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;

    @GetMapping(value = "/publish")
    public String publish() {
        return "publish";
    }

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
        if (StringUtils.isEmpty(title)) {
            model.addAttribute("error", "title不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(description)) {
            model.addAttribute("error", "description不能为空");
            return "publish";

        }
        if (StringUtils.isEmpty(tag)) {
            model.addAttribute("error", "tag不能为空");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    user = userMapper.findByToken(cookie.getValue());
                    if (user != null) {
                        httpServletRequest.getSession().setAttribute("gitHubUser", user);
                    }
                    break;
                }
            }
        }
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
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