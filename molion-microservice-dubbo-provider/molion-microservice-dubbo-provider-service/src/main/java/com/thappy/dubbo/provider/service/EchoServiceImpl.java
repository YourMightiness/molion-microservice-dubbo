package com.thappy.dubbo.provider.service;

import com.thappy.dubbo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: EchoServiceImpl</p>
 * <p>Description: </p>
 * 服务提供者
 * 既对外提供RESTful服务，又对内提供Dubbo RPC服务
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/18 17:16
 */
@Service(version = "1.0.0")
@RequestMapping("/provider")
@RestController
@RefreshScope
public class EchoServiceImpl implements EchoService {

    @Value("${server.port}")
    private int port;

    @GetMapping("/echo/{str}")
    @Override
    public String echo(@PathVariable(value = "str") String string) {
        return "Spring Cloud Alibaba Hello，I am " + string + "，from " + port;
    }
}
