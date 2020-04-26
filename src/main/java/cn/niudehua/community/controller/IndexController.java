package cn.niudehua.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: deng
 * @datetime: 2020/4/26 2:52 下午
 * @desc:
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }


}

