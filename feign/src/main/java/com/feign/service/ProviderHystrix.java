package com.feign.service;

import org.springframework.stereotype.Component;

/**
 * 断路器实现
 * @author
 */
@Component
public class ProviderHystrix implements IInvokeProvider {

    @Override
    public String testRest() {
        return "sorry, service is invalid";
    }
}
