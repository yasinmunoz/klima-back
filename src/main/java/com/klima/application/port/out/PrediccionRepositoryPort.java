package com.klima.application.port.out;

public interface PrediccionRepositoryPort <T> {

    T getPrediccionMananaMunicipio(String municipioId);
}
