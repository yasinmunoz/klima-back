package com.klima.application.service;

import com.klima.application.port.in.GetAllMunicipiosUseCase;
import com.klima.application.port.out.MunicipioRepositoryPort;

import com.klima.domain.errors.MunicipioMsgError;

import com.klima.domain.model.Municipio;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Slf4j
@Service
public class MunicipioService implements GetAllMunicipiosUseCase {

    @Autowired
    MunicipioRepositoryPort municipioRepositoryPort;

    @Override
    public List<Municipio> getMatchMunicipios(String municipio) {

        log.info("Method: getMatchMunicipios");
        log.debug("Method: getMatchMunicipios. Params: municipio='{}'", municipio);

        try {

            String response = (String) municipioRepositoryPort.getAllMunicipios();

            return List.of(new ObjectMapper().readValue(response, Municipio[].class)).stream()
                    .filter(m -> m.nombre().toLowerCase().contains(municipio.trim().toLowerCase()))
                    .toList();

        } catch (HttpClientErrorException ex){
            log.error("Method: getMatchMunicipios - HttpClientErrorException: ", ex);
            throw new HttpClientErrorException(ex.getStatusCode(), ex.getMessage());
        } catch (ResourceAccessException ex) {
            log.error("Method: getMatchMunicipios - ResourceAccessException: ", ex);
            throw new ResourceAccessException(ex.getMessage());
        } catch (Exception ex) {
            log.error("Method: getMatchMunicipios - Exception: ", ex);
            throw new RuntimeException(MunicipioMsgError.ERROR_INESPERADO);
        }
    }
}
