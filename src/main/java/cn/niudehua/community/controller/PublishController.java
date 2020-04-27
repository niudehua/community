package cn.niudehua.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: deng
 * @datetime: 2020/4/27 2:01 下午
 * @desc:
 */
@Controller
public class PublishController {
    @GetMapping(value = "/publish")
    public String publish() {
        return "publish";
    }
}
