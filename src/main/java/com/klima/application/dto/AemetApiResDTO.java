package com.klima.application.dto;

public record AemetApiResDTO(
        String descripcion,
        Integer estado,
        String datos,
        String metadatos
) { }