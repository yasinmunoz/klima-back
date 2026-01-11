package com.klima.municipio.it;

import com.klima.municipio.mock.AemetMockData;
import com.klima.municipio.mock.MunicipioMockData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.http.Fault;

import org.wiremock.spring.EnableWireMock;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureMockMvc
@EnableWireMock()
public class MunicipioControllerIT {

    @Value("${aemetapi.key}")
    private String apiKey;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CacheManager cacheManager;

    @RegisterExtension
    static WireMockExtension wiremock = WireMockExtension.newInstance()
            .options(wireMockConfig().port(8081))
            .build();

    @BeforeEach
    void setUp() {
        wiremock.resetAll();

        cacheManager.getCacheNames().forEach(cacheName -> {
            Cache cache = cacheManager.getCache(cacheName);
            if (cache != null) cache.clear();
        });
    }

    @Test
    void When_GetMatchMunicipios_Then_Successful() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));

        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(MunicipioMockData.AEMET_ALL_MUNICIPIOS_RESPONSE)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_TooManyRequestError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(429)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isTooManyRequests())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_TooManyRequestError_2() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));

        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse().withStatus(429)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isTooManyRequests())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_BadRequestError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(400)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_BadRequestError_2() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));

        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse().withStatus(400)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_ForbiddenError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(403)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_ForbiddenError_2() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));

        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse().withStatus(403)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_NotFoundError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(404)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_NotFoundError_2() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));

        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse().withStatus(404)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_RequestTimeoutError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(AemetMockData.API_RESPONSE)));


        wiremock.stubFor(get(urlPathEqualTo("/opendata/sh/qwer1234"))
                .willReturn(aResponse().withStatus(408)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isRequestTimeout())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_Unauthorized() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(401)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_ServiceUnavailableError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withFault(Fault.CONNECTION_RESET_BY_PEER)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isServiceUnavailable())
                .andReturn();
    }

    @Test
    void When_GetMatchMunicipios_Then_InternalServerError() throws Exception {

        //Arrange
        wiremock.stubFor(get(urlPathEqualTo("/opendata/api/maestro/municipios"))
                .withQueryParam("api_key", equalTo(apiKey))
                .willReturn(aResponse().withStatus(500)));

        //Act & Asserts
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/municipios")
                                .param("municipio", "Madrid")
                )
                .andExpect(status().isInternalServerError())
                .andReturn();
    }
}
