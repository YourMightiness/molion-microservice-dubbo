package com.thappy.dubbo.customer.service.service;

import com.thappy.dubbo.customer.service.fallback.NacosProviderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Title: NacosProviderService</p>
 * <p>Description: </p>
 * Feign默认实现负载均衡
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/20 9:56
 */
@FeignClient(name= "nacos-provider", fallback = NacosProviderFallBack.class)
public interface NacosProviderService {

    @GetMapping(value = "/provider/echo/{message}")
    String echo(@PathVariable("message") String message);
}
