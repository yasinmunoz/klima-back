package com.klima.application.port.in;

import com.klima.domain.model.Prediccion;

public interface GetPrediccionMananaMunicipioUseCase {

    Prediccion getPrediccionMananaMunicipio(String municipioId, String unitTemperature);
}
