package org.mc.study.server.message.netty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author machao
 * @date 2019-12-11
 */
@Slf4j
@RestController
@RequestMapping("")
public class TestController {

    @RequestMapping("/index")
    public String index(){
        log.error("index log");
        return "index";
    }

}
