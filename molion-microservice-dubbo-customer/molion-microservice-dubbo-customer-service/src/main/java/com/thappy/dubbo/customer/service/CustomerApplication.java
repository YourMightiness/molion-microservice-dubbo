package com.thappy.dubbo.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>Title: CustomerApplication</p>
 * <p>Description: </p>
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/19 0:46
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
