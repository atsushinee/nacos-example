package com.lichunorz.nacos.springboot;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discovery")
public class NacosDiscoveryController {

    @NacosInjected
    private NamingService namingService;

    /*
        启动服务发现,配置 nacos.server-addr=127.0.0.1:8848

        调用 http://localhost:8080/discovery/get?serviceName=example 返回空数组
        通过 put http://localhost:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080
        再次调用 get:
        [
            {
                "instanceId": "127.0.0.1#8080#DEFAULT#DEFAULT_GROUP@@example",
                "ip": "127.0.0.1",
                "port": 8080,
                "weight": 1.0,
                "healthy": true,
                "enabled": true,
                "ephemeral": true,
                "clusterName": "DEFAULT",
                "serviceName": "DEFAULT_GROUP@@example",
                "metadata": {},
                "instanceHeartBeatTimeOut": 15000,
                "instanceHeartBeatInterval": 5000,
                "ipDeleteTimeout": 30000
            }
        ]
     */

    @GetMapping("/get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
