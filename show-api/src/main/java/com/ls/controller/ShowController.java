package com.ls.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangzhuang
 * @Date: 2019/1/30 16:28
 * @Description:
 */
@RestController("show")
@RequestMapping("/show")
@Slf4j
public class ShowController {

    @GetMapping("/get/{s}")
    public String getString(@PathVariable String s){
        log.info(s);
        return s;
    }
}
