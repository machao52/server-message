package org.mc.study.server.message.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author machao
 * @date 2020-05-14
 */

@RestController
@RequestMapping("kafka")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/send")
    public String send(String message) {
        kafkaTemplate.send("test_topic", message);
        return "发送成功";
    }


}
