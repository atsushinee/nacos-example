package com.lichunorz.nacos.springboot;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 使用 注解 加载 dataId 为 example 的配置源,并开启自动更新
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class NacosSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSpringBootApplication.class, args);
    }


}
