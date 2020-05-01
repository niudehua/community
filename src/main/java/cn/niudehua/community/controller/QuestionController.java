package cn.niudehua.community.controller;

import cn.niudehua.community.dto.QuestionDTO;
import cn.niudehua.community.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: deng
 * @datetime: 2020/4/30 11:36 下午
 * @desc:
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping(value = "/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("questionDTO", questionDTO);
        return "question";
    }
}
