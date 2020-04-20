package com.thappy.dubbo.customer.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: NacosConsumerConfiguration</p>
 * <p>Description: </p>
 * RestTemplate--Restful风格调用工具bean
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/20 9:42
 */
@Configuration
public class NacosConsumerConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
