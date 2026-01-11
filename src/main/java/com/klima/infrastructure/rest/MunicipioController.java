package com.klima.infrastructure.rest;

import com.klima.application.port.in.GetAllMunicipiosUseCase;

import com.klima.domain.model.Municipio;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    GetAllMunicipiosUseCase getAllMunicipiosUseCase;

    @GetMapping
    public ResponseEntity<List<Municipio>> getMatchMunicipios(@RequestParam String municipio) {

        log.info("Method: getMatchMunicipios");
        log.debug("Method: getMatchMunicipios. Params: municipio='{}'", municipio);

        List<Municipio> result = getAllMunicipiosUseCase.getMatchMunicipios(municipio);

        log.info("Method: getMatchMunicipios OK");
        return ResponseEntity.ok(result);
    }
}
