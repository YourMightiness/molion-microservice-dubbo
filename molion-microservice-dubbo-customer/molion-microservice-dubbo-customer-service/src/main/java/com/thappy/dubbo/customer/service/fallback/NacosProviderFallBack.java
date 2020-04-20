package com.thappy.dubbo.customer.service.fallback;

import com.thappy.dubbo.customer.service.service.NacosProviderService;
import org.springframework.stereotype.Component;

/**
 * <p>Title: NacosProviderFallBack</p>
 * <p>Description: </p>
 * 熔断类
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/20 10:01
 */
@Component
public class NacosProviderFallBack implements NacosProviderService {
    @Override
    public String echo(String message) {
        return "请求失败, 请检查您的网络...";
    }
}
