package cn.niudehua.community.advice;

import cn.niudehua.community.controller.ResultDTO;
import cn.niudehua.community.exception.CustomizeErrorCode;
import cn.niudehua.community.exception.CustomizeException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: deng
 * @datetime: 2020/5/2 10:31 上午
 * @desc: 定制异常处理
 */
@ControllerAdvice
@Slf4j
public class CustomizeExceptionHandle {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable ex, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if ("application/json".equals(httpServletRequest.getContentType())) {
            ResultDTO resultDTO;
            // 返回 JSON
            if (ex instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            } else {
                log.error("handle error", ex);
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(200);
                httpServletResponse.setCharacterEncoding("utf-8");
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioException) {
            }
            return null;
        } else {
            // 错误页面跳转
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                log.error("handle error", ex);
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }


}
