package com.klima.prediccion.ut;

import com.klima.application.port.out.PrediccionRepositoryPort;
import com.klima.application.service.PrediccionService;

import com.klima.domain.errors.PrediccionMsgError;
import com.klima.domain.model.Prediccion;

import com.klima.prediccion.mock.PrediccionMockData;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureMockMvc
public class PrediccionServiceUT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PrediccionService prediccionService;

    @MockitoBean
    private PrediccionRepositoryPort<?> prediccionRepositoryPort;

    @Test
    void When_GetPrediccionMananaMunicipio_Then_OK_WithoutData() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenReturn(PrediccionMockData.AEMET_PREDICCION_MUNICIPIO_WITHOUT_DATA);

        //Act
        Prediccion result = prediccionService.getPrediccionMananaMunicipio(
                PrediccionMockData.MUNICIPIO_ID,
                PrediccionMockData.CELSIUS_UNIT_TEMPERATURE
        );

        assertNotNull(result);
        assertNull(result.mediaTemperatura());
        assertNull(result.unidadTemperatura());
        assertTrue(result.probPrecipitacion().isEmpty());
    }


    @Test
    void When_GetPrediccionMananaMunicipio_Then_OK_WithDataCelsius() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenReturn(PrediccionMockData.AEMET_PREDICCION_MUNICIPIO_WITH_DATA);

        //Act
        Prediccion result = prediccionService.getPrediccionMananaMunicipio(
                PrediccionMockData.MUNICIPIO_ID,
                PrediccionMockData.CELSIUS_UNIT_TEMPERATURE
        );

        assertNotNull(result);
        assertNotNull(result.mediaTemperatura());
        assertNotNull(result.unidadTemperatura());
        assertFalse(result.probPrecipitacion().isEmpty());
    }

    @Test
    void When_GetPrediccionMananaMunicipio_Then_OK_WithDataFahrenheit() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenReturn(PrediccionMockData.AEMET_PREDICCION_MUNICIPIO_WITH_DATA);

        //Act
        Prediccion result = prediccionService.getPrediccionMananaMunicipio(
                PrediccionMockData.MUNICIPIO_ID,
                PrediccionMockData.FAHRENHEIT_UNIT_TEMPERATURE
        );

        assertNotNull(result);
        assertNotNull(result.mediaTemperatura());
        assertNotNull(result.unidadTemperatura());
        assertFalse(result.probPrecipitacion().isEmpty());
    }

    @Test
    void When_GetPrediccionMananaMunicipio_HttpClientErrorException() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenThrow(new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS));

        // Act & Asserts
        HttpClientErrorException exception = assertThrows(
                HttpClientErrorException.class,
                () -> prediccionService.getPrediccionMananaMunicipio(
                        PrediccionMockData.MUNICIPIO_ID,
                        PrediccionMockData.CELSIUS_UNIT_TEMPERATURE
                )
        );

        assertEquals(HttpStatus.TOO_MANY_REQUESTS, exception.getStatusCode());
        verify(prediccionRepositoryPort, times(1))
                .getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID);
    }

    @Test
    void When_GetPrediccionMananaMunicipio_ResourceAccessException() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenThrow(ResourceAccessException.class);

        // Act & Asserts
        ResourceAccessException exception = assertThrows(
                ResourceAccessException.class,
                () -> prediccionService.getPrediccionMananaMunicipio(
                        PrediccionMockData.MUNICIPIO_ID,
                        PrediccionMockData.CELSIUS_UNIT_TEMPERATURE
                )
        );

        verify(prediccionRepositoryPort, times(1))
                .getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID);
    }

    @Test
    void When_GetPrediccionMananaMunicipio_RuntimeException() {

        // Arrange
        when((String) prediccionRepositoryPort.getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID))
                .thenThrow(RuntimeException.class);

        // Act & Asserts
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> prediccionService.getPrediccionMananaMunicipio(
                        PrediccionMockData.MUNICIPIO_ID,
                        PrediccionMockData.CELSIUS_UNIT_TEMPERATURE
                )
        );

        assertEquals(PrediccionMsgError.ERROR_INESPERADO, exception.getMessage());
        verify(prediccionRepositoryPort, times(1))
                .getPrediccionMananaMunicipio(PrediccionMockData.MUNICIPIO_ID);
    }

}
