package com.lichunorz.nacos.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
// 通过 spring cloud 原生注解 @RefreshScope 实现配置自动更新
@RefreshScope
public class NacosConfigController {

    @Value("${useLocalCache:true}")
    private boolean useLocalCache;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

}
