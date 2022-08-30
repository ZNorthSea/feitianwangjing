package com.feitian.study.equipment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Zhaotianjun
 * @version : 1.0.0
 * @doc : 请求控制器
 * @createdate : 2022/08/30 11:31
 */

@RestController
@Slf4j
public class RequestController {
    /**
     * @param name 名字
     * @return {@link String }
     * @doc : 你好
     * @createdate : 2022/08/30 11:31
     * @author : Zhaotianjun
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return name;
    }


    /**
     * @return {@link String }
     * @doc : 得到所有日期
     * @createdate : 2022/08/30 11:33
     * @author : Zhaotianjun
     */
    @GetMapping("/getAllDate")
    public String getAllDate() {
        return "all data";
    }

    @GetMapping("/getData")
    public String selectOneData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        System.out.println("name = " + name);
        System.out.println("id = " + id);
        return "success";
    }

}
