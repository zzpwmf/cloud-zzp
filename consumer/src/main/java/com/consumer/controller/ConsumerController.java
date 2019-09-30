package com.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费端
 * @author zzp
 */
@Slf4j
@RestController
@RequestMapping("/consumerCon")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/testConsumer")
    public String consumerTest() {
        log.info("testConsumer start");
        return restTemplate.getForEntity("http://provider-zzp/provider/hello", String.class).getBody();
    }

}
