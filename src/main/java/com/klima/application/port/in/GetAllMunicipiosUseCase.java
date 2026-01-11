package com.klima.application.port.in;

import com.klima.domain.model.Municipio;

import java.util.List;

public interface GetAllMunicipiosUseCase {

    List<Municipio> getMatchMunicipios(String municipio);
}
