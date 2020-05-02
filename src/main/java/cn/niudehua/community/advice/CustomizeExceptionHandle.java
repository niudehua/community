package cn.niudehua.community.advice;

import cn.niudehua.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: deng
 * @datetime: 2020/5/2 10:31 上午
 * @desc: 定制异常处理
 */
@ControllerAdvice
public class CustomizeExceptionHandle {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable ex, Model model) {
        if (ex instanceof CustomizeException) {
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message", "!!!!!!!");
        }
        return new ModelAndView("error");
    }


}
