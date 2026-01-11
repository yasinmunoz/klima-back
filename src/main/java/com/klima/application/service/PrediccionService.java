package com.klima.application.service;

import com.klima.application.dto.AemetPrediccionMananaMunicipioDTO;
import com.klima.application.port.in.GetPrediccionMananaMunicipioUseCase;
import com.klima.application.port.out.PrediccionRepositoryPort;

import com.klima.domain.errors.PrediccionMsgError;
import com.klima.domain.model.Prediccion;

import com.klima.domain.model.ProbabilidadPrecipitacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PrediccionService implements GetPrediccionMananaMunicipioUseCase {

    @Autowired
    PrediccionRepositoryPort prediccionRepositoryPort;

    @Override
    public Prediccion getPrediccionMananaMunicipio(String municipioId, String unitTemperature) {
        try {

            log.info("Method: getPrediccionMananaMunicipio");
            log.debug("Method: getPrediccionMananaMunicipio. " +
                    "Params: municipioId='{}', unitTemperature='{}'", municipioId, unitTemperature);

            String response = (String) prediccionRepositoryPort.getPrediccionMananaMunicipio(municipioId);

            List<AemetPrediccionMananaMunicipioDTO> prediccion = List.of(
                    new ObjectMapper().readValue(response, AemetPrediccionMananaMunicipioDTO[].class)
            );

            AemetPrediccionMananaMunicipioDTO.DiaDTO diaManana = getDiaManana(prediccion);

            Double temperaturaMedia = null;

            if (diaManana != null && !diaManana.temperatura().dato().isEmpty()) {
                temperaturaMedia = getTemperaturaMedia(diaManana, unitTemperature);
            }

            List<AemetPrediccionMananaMunicipioDTO.PeriodoValorIntDTO> probPrecipitacion = null;
            if (diaManana != null && diaManana.probPrecipitacion() != null) {
                probPrecipitacion = getProbPrecipitacion(diaManana);
            }

            return new Prediccion(
                    temperaturaMedia != null
                            ? temperaturaMedia.floatValue()
                            : null,
                    temperaturaMedia != null
                            ? unitTemperature
                            : null,
                    probPrecipitacion != null
                            ? probPrecipitacion.stream()
                            .map(p -> new ProbabilidadPrecipitacion(p.value(), p.periodo()))
                            .toList()
                            : null
            );

        } catch (HttpClientErrorException ex){
            log.error("Method: getMatchMunicipios - HttpClientErrorException: ", ex);
            throw new HttpClientErrorException(ex.getStatusCode(), ex.getMessage());
        } catch (ResourceAccessException ex) {
            log.error("Method: getMatchMunicipios - ResourceAccessException: ", ex);
            throw new ResourceAccessException(ex.getMessage());
        } catch (Exception ex) {
            log.error("Method: getMatchMunicipios - Exception: ", ex);
            throw new RuntimeException(PrediccionMsgError.ERROR_INESPERADO);
        }
    }

    public AemetPrediccionMananaMunicipioDTO.DiaDTO getDiaManana(List<AemetPrediccionMananaMunicipioDTO> prediccion) {

        log.info("Method: getDiaManana");
        log.debug("Method: getDiaManana. Params: prediccion='{}'", prediccion);

        return prediccion.stream()
                .flatMap(p -> p.prediccion().dia().stream())
                .filter(d -> d.fecha().toLocalDate().isEqual(LocalDate.now().plusDays(1)))
                .findFirst()
                .orElse(null);

    }

    public Double getTemperaturaMedia (AemetPrediccionMananaMunicipioDTO.DiaDTO diaManana, String unitTemperature) {

        return diaManana.temperatura().dato().stream()
                .mapToDouble(d -> {
                    if (unitTemperature.equalsIgnoreCase("f")) {
                        return (d.value() * 9.0 / 5.0) + 32;
                    } else {
                        return d.value();
                    }
                })
                .sum() / diaManana.temperatura().dato().size();
    }

    public List<AemetPrediccionMananaMunicipioDTO.PeriodoValorIntDTO> getProbPrecipitacion (
            AemetPrediccionMananaMunicipioDTO.DiaDTO diaManana
    ) {

        log.info("Method: getProbPrecipitacion");
        log.debug("Method: getProbPrecipitacion. Params: diaManana='{}'", diaManana);

        return diaManana.probPrecipitacion().stream()
                .filter(p -> !(
                                p.periodo().equals("00-24") ||
                                p.periodo().equals("00-12") ||
                                p.periodo().equals("12-24")
                        )
                )
                .toList();
    }
}
