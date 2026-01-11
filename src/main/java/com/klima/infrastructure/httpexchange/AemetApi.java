package com.klima.infrastructure.httpexchange;

import com.klima.application.dto.AemetApiResDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface AemetApi {

    @GetExchange ("/opendata/api/maestro/municipios")
    AemetApiResDTO getMunicipios();

    @GetExchange("opendata/api/prediccion/especifica/municipio/diaria/{municipioId}")
    AemetApiResDTO getPrediccionMananaMunicipio(@PathVariable("municipioId") String municipioId);
}
