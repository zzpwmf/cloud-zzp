package com.feign.controller;

import com.feign.service.IInvokeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign测试
 * @author
 */
@Slf4j
@RestController
public class FeignController {

    @Autowired
    private IInvokeProvider iInvokeProvider;

    /**
     * 提供者测试
     * @return
     */
    @RequestMapping("/hello")
    public String testProvider() {
        log.info("invoke feign server");
        return iInvokeProvider.testRest();
    }

}
