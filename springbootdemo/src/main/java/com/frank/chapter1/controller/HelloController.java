package com.frank.chapter1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jianweilin on 2017/10/9.
 */
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v3/alert/applications/{systemId}/polices")
    public String index(HttpServletRequest request, @PathVariable Long systemId){
        System.out.println("systemId====: " + systemId);
        return "Hello World!";
    }
}
