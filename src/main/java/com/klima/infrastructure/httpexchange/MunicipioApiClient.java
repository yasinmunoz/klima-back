package com.klima.infrastructure.httpexchange;

import com.klima.application.port.out.MunicipioRepositoryPort;
import com.klima.application.dto.AemetApiResDTO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Slf4j
@Repository
public class MunicipioApiClient implements MunicipioRepositoryPort {

    @Autowired
    AemetApi aemetApi;

    @Override
    @Cacheable(value = "municipiosCache")
    public String getAllMunicipios() {

        log.info("Method: getAllMunicipios");
        AemetApiResDTO response = aemetApi.getMunicipios();

        log.debug("Method: getAllMunicipios. Obteniendo datos de {}", response.datos());
        return RestClient.create()
                .get()
                .uri(URI.create(response.datos()))
                .retrieve()
                .body(String.class);
    }
}
