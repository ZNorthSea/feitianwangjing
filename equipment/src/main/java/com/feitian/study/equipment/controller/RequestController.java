package com.feitian.study.equipment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Zhaotianjun
 * @version : 1.0.0
 * @createdate : 2022/08/30 11:24
 * @doc : 请求控制器
 */

@RestController
@Slf4j
public class RequestController {
    /**
     * @param name 名字
     * @return {@link String }
     * @createdate : 2022/08/30 11:25
     * @author : Zhaotianjun
     * @doc : 你好
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return name;
    }

}
