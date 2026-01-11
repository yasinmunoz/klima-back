package com.klima.infrastructure.rest;

import com.klima.application.port.in.GetPrediccionMananaMunicipioUseCase;
import com.klima.domain.model.Prediccion;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/predicciones")
public class PrediccionController {

    @Autowired
    GetPrediccionMananaMunicipioUseCase getPrediccionMananaMunicipioUseCase;

    @GetMapping
    public ResponseEntity<Prediccion> getPrediccionMananaMunicipio(
            @RequestParam String municipioId,
            @RequestParam String unitTemperature
    ) {

        log.info("Method: getPrediccionMananaMunicipio");
        log.debug("Method: getPrediccionMananaMunicipio. " +
                "Params: municipioId='{}', unitTemperature='{}'", municipioId, unitTemperature);

        Prediccion result =
                getPrediccionMananaMunicipioUseCase.getPrediccionMananaMunicipio(municipioId, unitTemperature);

        log.info("Method: getPrediccionMananaMunicipio OK");
        return ResponseEntity.ok(result);
    }


}
