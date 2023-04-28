package com.example.securitymaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    public String exception(Throwable t, HttpServletResponse response, Model model) {
//        String cause = t != null ?
//        model.addAttribute("statusCode", cause);
        String msg = t != null ? t.getMessage() : "unknown error";
        model.addAttribute("msg", msg);
        int code = switch (msg) {
            case "Unknown error" -> 500;
            case "Access is denied" -> 403;
            default -> 500;
        };
        model.addAttribute("statusCode", code);
        return "error";
    }
}
