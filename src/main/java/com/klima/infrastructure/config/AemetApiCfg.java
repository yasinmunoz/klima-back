package com.klima.infrastructure.config;

import lombok.Data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Data
@Configuration
@ConfigurationProperties("aemetapi")
public class AemetApiCfg implements InitializingBean {

    private String schema;
    private String host;
    private Integer port;
    private String key;

    @Override
    public void afterPropertiesSet() {
        Assert.hasText(schema, "'schema' must not be empty");
        Assert.hasText(host, "'host' must not be empty");
        Assert.notNull(port, "'port' must not be null");
        Assert.hasText(key, "'key' must not be empty");
    }
}
