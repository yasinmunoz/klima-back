package com.klima.municipio.ut;

import com.klima.application.port.out.MunicipioRepositoryPort;
import com.klima.application.service.MunicipioService;

import com.klima.domain.errors.MunicipioMsgError;

import com.klima.domain.model.Municipio;
import com.klima.municipio.mock.MunicipioMockData;

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

import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureMockMvc
public class MunicipioServiceUT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MunicipioService municipioService;

    @MockitoBean
    private MunicipioRepositoryPort<?> municipioRepositoryPort;

    @Test
    void When_GetMatchMunicipios_Then_OK() {

        // Arrange
        when((String) municipioRepositoryPort.getAllMunicipios())
                .thenReturn(MunicipioMockData.AEMET_ALL_MUNICIPIOS_RESPONSE);

        List<Municipio> expectedMunicipios =
                List.of(new ObjectMapper().readValue(MunicipioMockData.AEMET_ALL_MUNICIPIOS_RESPONSE, Municipio[].class)).stream()
                .filter(m -> m.nombre().toLowerCase().contains(MunicipioMockData.MUNICIPIO.trim().toLowerCase()))
                .toList();

        // Act
        List<Municipio> result = municipioService.getMatchMunicipios(MunicipioMockData.MUNICIPIO);

        // Asserts
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedMunicipios,result);
        verify(municipioRepositoryPort, times(1)).getAllMunicipios();
    }

    @Test
    void When_GetMatchMunicipios_Then_OK_2() {

        // Arrange
        when((String) municipioRepositoryPort.getAllMunicipios())
                .thenReturn(MunicipioMockData.AEMET_ALL_MUNICIPIOS_RESPONSE);

        List<Municipio> expectedMunicipios =
                List.of(new ObjectMapper().readValue(MunicipioMockData.AEMET_ALL_MUNICIPIOS_RESPONSE, Municipio[].class)).stream()
                .filter(m -> m.nombre().toLowerCase().contains(MunicipioMockData.MUNICIPIO_2.trim().toLowerCase()))
                .toList();

        // Act
        List<Municipio> result = municipioService.getMatchMunicipios(MunicipioMockData.MUNICIPIO_2);

        // Asserts
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(expectedMunicipios, result);
        verify(municipioRepositoryPort, times(1)).getAllMunicipios();
    }

    @Test
    void When_GetMatchMunicipios_Then_HttpClientErrorException() {

        // Arrange
        when((String) municipioRepositoryPort.getAllMunicipios())
                .thenThrow(new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS));

        // Act & Asserts
        HttpClientErrorException exception = assertThrows(
                HttpClientErrorException.class,
                () -> municipioService.getMatchMunicipios(MunicipioMockData.MUNICIPIO)
        );

        assertEquals(HttpStatus.TOO_MANY_REQUESTS, exception.getStatusCode());
        verify(municipioRepositoryPort, times(1)).getAllMunicipios();
    }

    @Test
    void When_GetMatchMunicipios_Then_ResourceAccessException() {

        // Arrange
        when((String) municipioRepositoryPort.getAllMunicipios())
                .thenThrow(ResourceAccessException.class);

        // Act & Asserts
        ResourceAccessException exception = assertThrows(
                ResourceAccessException.class,
                () -> municipioService.getMatchMunicipios(MunicipioMockData.MUNICIPIO)
        );

        verify(municipioRepositoryPort, times(1)).getAllMunicipios();
    }

    @Test
    void When_GetMatchMunicipios_Then_RuntimeException() {

        // Arrange
        when((String) municipioRepositoryPort.getAllMunicipios())
                .thenThrow(new RuntimeException());

        // Act & Asserts
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> municipioService.getMatchMunicipios(MunicipioMockData.MUNICIPIO)
        );

        assertEquals(MunicipioMsgError.ERROR_INESPERADO, exception.getMessage());
        verify(municipioRepositoryPort, times(1)).getAllMunicipios();
    }
}
