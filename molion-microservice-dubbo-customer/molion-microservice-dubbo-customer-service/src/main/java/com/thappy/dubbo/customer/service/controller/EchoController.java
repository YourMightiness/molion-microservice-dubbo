package com.thappy.dubbo.customer.service.controller;

import com.thappy.dubbo.customer.service.service.NacosProviderService;
import com.thappy.dubbo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: EchoController</p>
 * <p>Description: </p>
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/19 0:57
 */
@RefreshScope
@RestController
@RequestMapping("/customer")
public class EchoController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NacosProviderService nacosProviderService;

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:12345")
    private EchoService echoService;

    /**
     * Dubbo-RPC调用
     */
    @GetMapping("/echo/rpc")
    public String echoByRpc(String msg){
        return echoService.echo(msg);
    }

    /**
     * RestFul调用
     * @return
     */
    @GetMapping(value = "/echo/rest")
    public String echoByRest(){
        ServiceInstance instance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/provider/echo/%s", instance.getHost(), instance.getPort(),appName);
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * Feign调用
     * @return
     */
    @GetMapping(value = "/echo/feign")
    public String echoByFegin(){
        return nacosProviderService.echo("Hello Feign");
    }

}
