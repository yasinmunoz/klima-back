package com.klima.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public record AemetPrediccionMananaMunicipioDTO(
        OrigenDTO origen,
        LocalDateTime elaborado,
        String nombre,
        String provincia,
        PrediccionDTO prediccion,
        Integer id,
        Double version
) {
    public record OrigenDTO(
            String productor,
            String web,
            String enlace,
            String language,
            String copyright,
            String notaLegal
    ) {}

    public record PrediccionDTO(
            List<DiaDTO> dia
    ) {}

    public record DiaDTO(
            List<PeriodoValorIntDTO> probPrecipitacion,
            List<PeriodoValorStringDTO> cotaNieveProv,
            List<EstadoCieloDTO> estadoCielo,
            List<VientoDTO> viento,
            List<PeriodoValorStringDTO> rachaMax,
            TemperaturaConHorasDTO temperatura,
            TemperaturaConHorasDTO sensTermica,
            HumedadRelativaConHorasDTO humedadRelativa,
            Integer uvMax,
            LocalDateTime fecha
    ) {}

    public record PeriodoValorIntDTO(
            Integer value,
            String periodo
    ) {}

    public record PeriodoValorStringDTO(
            String value,
            String periodo
    ) {}

    public record EstadoCieloDTO(
            String value,
            String periodo,
            String descripcion
    ) {}

    public record VientoDTO(
            String direccion,
            Integer velocidad,
            String periodo
    ) {}

    public record TemperaturaConHorasDTO(
            Integer maxima,
            Integer minima,
            List<HoraValorIntDTO> dato
    ) {}

    public record HumedadRelativaConHorasDTO(
            Integer maxima,
            Integer minima,
            List<HoraValorIntDTO> dato
    ) {}

    public record HoraValorIntDTO(
            Integer value,
            Integer hora
    ) {}
}