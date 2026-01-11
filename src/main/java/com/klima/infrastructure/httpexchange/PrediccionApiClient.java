package com.klima.infrastructure.httpexchange;

import com.klima.application.dto.AemetApiResDTO;
import com.klima.application.port.out.PrediccionRepositoryPort;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Slf4j
@Repository
public class PrediccionApiClient implements PrediccionRepositoryPort {

    @Autowired
    AemetApi aemetApi;

    @Override
    public String getPrediccionMananaMunicipio(String municipioId) {

        log.info("Method: getPrediccionMananaMunicipio");
        log.debug("Method: getPrediccionMananaMunicipio. Params: municipioId='{}'", municipioId);

        AemetApiResDTO response = aemetApi.getPrediccionMananaMunicipio(municipioId);

        log.debug("Method: getPrediccionMananaMunicipio. Obteniendo datos de {}", response.datos());
        return RestClient.create()
                .get()
                .uri(URI.create(response.datos()))
                .retrieve()
                .body(String.class);
    }
}
