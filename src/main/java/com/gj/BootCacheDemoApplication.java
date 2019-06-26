package com.gj;

import cn.gjing.core.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableSwagger
@EnableJpaAuditing
@EnableCaching
public class BootCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCacheDemoApplication.class, args);
    }

}
