package org.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice // Controller와 다름
@Log4j2
public class CommonExceptionAdvice {
    @ResponseBody
    // response
    @ExceptionHandler(NumberFormatException.class)
    public String exceptionHandler(NumberFormatException e) {
        log.error("----------------------------------");
        log.error(e.getMessage());

        return "NumberFormatException";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class) // 범용
    public String exceptCommon(Exception e) {
        log.error("----------------------------------");
        log.error(e.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>"+e.getMessage()+"</li>"); // html 추가

        Arrays.stream(e.getStackTrace())
                .forEach(element-> {
                    buffer.append("<li>"+element+"</li>");
                });
        buffer.append("</ul>");
        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
