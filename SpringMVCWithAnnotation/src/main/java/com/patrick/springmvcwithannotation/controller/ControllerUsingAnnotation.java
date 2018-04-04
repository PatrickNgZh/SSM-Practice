package com.patrick.springmvcwithannotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author peicong
 * @date 2018/4/4 0004
 */
@Controller
public class ControllerUsingAnnotation {
    @RequestMapping(value = "/ControllerUsingAnnotation")
    public String handleRequest(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Model model) {
        model.addAttribute("msg", "SpringMVC using annotation");
        return "index";
    }
}
