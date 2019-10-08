package com.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider-zzp", fallback = ProviderHystrix.class)
public interface IInvokeProvider {

    @RequestMapping("/hello")
    String testRest();
}
