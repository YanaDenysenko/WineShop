package com.WineStore.WineStore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = {
        "com.WineStore.WineStore.service",
        "com.WineStore.WineStore.repository",
        "com.WineStore.WineStore.mapper"
})
public class AppConfig {
}
