package com.klima.infrastructure.config;

import com.klima.infrastructure.httpexchange.AemetApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class AemetApiClientCfg {

    @Bean
    public AemetApi aemetApiClient(AemetApiCfg aemetApiCfg) {

        URI apiUri = UriComponentsBuilder.newInstance()
                .scheme(aemetApiCfg.getSchema())
                .host(aemetApiCfg.getHost())
                .port(aemetApiCfg.getPort())
                .queryParam("api_key", aemetApiCfg.getKey())
                .build(Map.of());

        RestClient restClient = RestClient.builder()
                .baseUrl(apiUri)
                .requestInterceptors(interceptors -> interceptors.clear())
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return httpServiceProxyFactory.createClient(AemetApi.class);
    }
}
