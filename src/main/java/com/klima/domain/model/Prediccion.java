package com.klima.domain.model;

import java.util.List;

public record Prediccion(
        Float mediaTemperatura,
        String unidadTemperatura,
        List<ProbabilidadPrecipitacion> probPrecipitacion
) { }
