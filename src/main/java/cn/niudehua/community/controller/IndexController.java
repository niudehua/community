package cn.niudehua.community.controller;

import cn.niudehua.community.dto.PaginationDTO;
import cn.niudehua.community.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: deng
 * @datetime: 2020/4/26 2:52 下午
 * @desc: 主页控制
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexController {
    private final QuestionService questionService;

    /**
     * @param page  当前页
     * @param size  每页数据条数
     * @param model 视图模型
     * @return 主页
     */
    @GetMapping("/")
    public String index(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "3") Integer size
            , Model model) {
        //获取问题列表
        PaginationDTO paginationDTO = questionService.list(page, size);
        model.addAttribute("paginationDTO", paginationDTO);
        return "index";
    }


}

