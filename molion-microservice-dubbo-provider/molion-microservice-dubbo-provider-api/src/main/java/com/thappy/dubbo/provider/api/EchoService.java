package com.thappy.dubbo.provider.api;

/**
 * <p>Title: EchoService</p>
 * <p>Description: </p>
 *
 * @author L丶慕留人
 * @version 1.0.0
 * @date 2020/4/18 17:04
 */
public interface EchoService {
    /**
     * dubbo 服务接口
     * @param string
     * @return
     */
    String echo(String string);
}
