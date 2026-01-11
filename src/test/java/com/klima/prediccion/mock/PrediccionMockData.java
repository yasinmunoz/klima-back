package com.klima.prediccion.mock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrediccionMockData {

    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static final String MUNICIPIO_ID = "28079";

    public static final String CELSIUS_UNIT_TEMPERATURE = "C";
    public static final String FAHRENHEIT_UNIT_TEMPERATURE = "F";

    public static final String AEMET_PREDICCION_MUNICIPIO_WITH_DATA = """
            [ {
              "origen" : {
                "productor" : "Agencia Estatal de Meteorología - AEMET. Gobierno de España",
                "web" : "https://www.aemet.es",
                "enlace" : "https://www.aemet.es/es/eltiempo/prediccion/municipios/madrid-id28079",
                "language" : "es",
                "copyright" : "© AEMET. Autorizado el uso de la información y su reproducción citando a AEMET como autora de la misma.",
                "notaLegal" : "https://www.aemet.es/es/nota_legal"
              },
              "elaborado" :"""
                    +"\"" + LocalDateTime.now().toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
              ,
              "nombre" : "Madrid",
              "provincia" : "Madrid",
              "prediccion" : {
                "dia" : [ {
                  "probPrecipitacion" : [ {
                    "value" : 0,
                    "periodo" : "00-24"
                  }, {
                    "value" : 0,
                    "periodo" : "00-12"
                  }, {
                    "value" : 0,
                    "periodo" : "12-24"
                  }, {
                    "value" : 0,
                    "periodo" : "00-06"
                  }, {
                    "value" : 0,
                    "periodo" : "06-12"
                  }, {
                    "value" : 0,
                    "periodo" : "12-18"
                  }, {
                    "value" : 0,
                    "periodo" : "18-24"
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-06"
                  }, {
                    "value" : "",
                    "periodo" : "06-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-18"
                  }, {
                    "value" : "",
                    "periodo" : "18-24"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "",
                    "periodo" : "00-24",
                    "descripcion" : ""
                  }, {
                    "value" : "",
                    "periodo" : "00-12",
                    "descripcion" : ""
                  }, {
                    "value" : "12",
                    "periodo" : "12-24",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "",
                    "periodo" : "00-06",
                    "descripcion" : ""
                  }, {
                    "value" : "12",
                    "periodo" : "06-12",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "12",
                    "periodo" : "12-18",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "17n",
                    "periodo" : "18-24",
                    "descripcion" : "Nubes altas"
                  } ],
                  "viento" : [ {
                    "direccion" : "",
                    "velocidad" : 0,
                    "periodo" : "00-24"
                  }, {
                    "direccion" : "",
                    "velocidad" : 0,
                    "periodo" : "00-12"
                  }, {
                    "direccion" : "NO",
                    "velocidad" : 5,
                    "periodo" : "12-24"
                  }, {
                    "direccion" : "NO",
                    "velocidad" : 10,
                    "periodo" : "00-06"
                  }, {
                    "direccion" : "C",
                    "velocidad" : 0,
                    "periodo" : "06-12"
                  }, {
                    "direccion" : "NO",
                    "velocidad" : 5,
                    "periodo" : "12-18"
                  }, {
                    "direccion" : "NE",
                    "velocidad" : 5,
                    "periodo" : "18-24"
                  } ],
                  "rachaMax" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-06"
                  }, {
                    "value" : "",
                    "periodo" : "06-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-18"
                  }, {
                    "value" : "",
                    "periodo" : "18-24"
                  } ],
                  "temperatura" : {
                    "maxima" : 10,
                    "minima" : 3,
                    "dato" : [ {
                      "value" : 5,
                      "hora" : 6
                    }, {
                      "value" : 8,
                      "hora" : 12
                    }, {
                      "value" : 7,
                      "hora" : 18
                    }, {
                      "value" : 2,
                      "hora" : 24
                    } ]
                  },
                  "sensTermica" : {
                    "maxima" : 10,
                    "minima" : 2,
                    "dato" : [ {
                      "value" : 3,
                      "hora" : 6
                    }, {
                      "value" : 8,
                      "hora" : 12
                    }, {
                      "value" : 7,
                      "hora" : 18
                    }, {
                      "value" : 2,
                      "hora" : 24
                    } ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 80,
                    "minima" : 55,
                    "dato" : [ {
                      "value" : 70,
                      "hora" : 6
                    }, {
                      "value" : 55,
                      "hora" : 12
                    }, {
                      "value" : 60,
                      "hora" : 18
                    }, {
                      "value" : 80,
                      "hora" : 24
                    } ]
                  },
                  "uvMax" : 1,
                  "fecha" : """ + "\"" + LocalDateTime.now().toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 0,
                    "periodo" : "00-24"
                  }, {
                    "value" : 0,
                    "periodo" : "00-12"
                  }, {
                    "value" : 0,
                    "periodo" : "12-24"
                  }, {
                    "value" : 0,
                    "periodo" : "00-06"
                  }, {
                    "value" : 0,
                    "periodo" : "06-12"
                  }, {
                    "value" : 0,
                    "periodo" : "12-18"
                  }, {
                    "value" : 0,
                    "periodo" : "18-24"
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-06"
                  }, {
                    "value" : "",
                    "periodo" : "06-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-18"
                  }, {
                    "value" : "",
                    "periodo" : "18-24"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "12",
                    "periodo" : "00-24",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "11",
                    "periodo" : "00-12",
                    "descripcion" : "Despejado"
                  }, {
                    "value" : "12",
                    "periodo" : "12-24",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "12n",
                    "periodo" : "00-06",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "11",
                    "periodo" : "06-12",
                    "descripcion" : "Despejado"
                  }, {
                    "value" : "12",
                    "periodo" : "12-18",
                    "descripcion" : "Poco nuboso"
                  }, {
                    "value" : "17n",
                    "periodo" : "18-24",
                    "descripcion" : "Nubes altas"
                  } ],
                  "viento" : [ {
                    "direccion" : "S",
                    "velocidad" : 5,
                    "periodo" : "00-24"
                  }, {
                    "direccion" : "NE",
                    "velocidad" : 10,
                    "periodo" : "00-12"
                  }, {
                    "direccion" : "SO",
                    "velocidad" : 10,
                    "periodo" : "12-24"
                  }, {
                    "direccion" : "NE",
                    "velocidad" : 10,
                    "periodo" : "00-06"
                  }, {
                    "direccion" : "S",
                    "velocidad" : 5,
                    "periodo" : "06-12"
                  }, {
                    "direccion" : "SO",
                    "velocidad" : 10,
                    "periodo" : "12-18"
                  }, {
                    "direccion" : "C",
                    "velocidad" : 0,
                    "periodo" : "18-24"
                  } ],
                  "rachaMax" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-06"
                  }, {
                    "value" : "",
                    "periodo" : "06-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-18"
                  }, {
                    "value" : "",
                    "periodo" : "18-24"
                  } ],
                  "temperatura" : {
                    "maxima" : 10,
                    "minima" : 2,
                    "dato" : [ {
                      "value" : 0,
                      "hora" : 6
                    }, {
                      "value" : 7,
                      "hora" : 12
                    }, {
                      "value" : 7,
                      "hora" : 18
                    }, {
                      "value" : 4,
                      "hora" : 24
                    } ]
                  },
                  "sensTermica" : {
                    "maxima" : 10,
                    "minima" : -3,
                    "dato" : [ {
                      "value" : -3,
                      "hora" : 6
                    }, {
                      "value" : 7,
                      "hora" : 12
                    }, {
                      "value" : 5,
                      "hora" : 18
                    }, {
                      "value" : 4,
                      "hora" : 24
                    } ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 100,
                    "minima" : 60,
                    "dato" : [ {
                      "value" : 90,
                      "hora" : 6
                    }, {
                      "value" : 65,
                      "hora" : 12
                    }, {
                      "value" : 80,
                      "hora" : 18
                    }, {
                      "value" : 95,
                      "hora" : 24
                    } ]
                  },
                  "uvMax" : 1,
                  "fecha" :""" + "\"" + LocalDateTime.now().toLocalDate().plusDays(1).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 10,
                    "periodo" : "00-24"
                  }, {
                    "value" : 5,
                    "periodo" : "00-12"
                  }, {
                    "value" : 0,
                    "periodo" : "12-24"
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "1700",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "16",
                    "periodo" : "00-24",
                    "descripcion" : "Cubierto"
                  }, {
                    "value" : "16",
                    "periodo" : "00-12",
                    "descripcion" : "Cubierto"
                  }, {
                    "value" : "15",
                    "periodo" : "12-24",
                    "descripcion" : "Muy nuboso"
                  } ],
                  "viento" : [ {
                    "direccion" : "C",
                    "velocidad" : 0,
                    "periodo" : "00-24"
                  }, {
                    "direccion" : "C",
                    "velocidad" : 0,
                    "periodo" : "00-12"
                  }, {
                    "direccion" : "C",
                    "velocidad" : 0,
                    "periodo" : "12-24"
                  } ],
                  "rachaMax" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  } ],
                  "temperatura" : {
                    "maxima" : 11,
                    "minima" : 3,
                    "dato" : [ ]
                  },
                  "sensTermica" : {
                    "maxima" : 11,
                    "minima" : 3,
                    "dato" : [ ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 100,
                    "minima" : 75,
                    "dato" : [ ]
                  },
                  "uvMax" : 1,
                  "fecha" : """ + "\"" + LocalDateTime.now().toLocalDate().plusDays(2).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 80,
                    "periodo" : "00-24"
                  }, {
                    "value" : 60,
                    "periodo" : "00-12"
                  }, {
                    "value" : 80,
                    "periodo" : "12-24"
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "1600",
                    "periodo" : "00-24"
                  }, {
                    "value" : "1500",
                    "periodo" : "00-12"
                  }, {
                    "value" : "1800",
                    "periodo" : "12-24"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "26",
                    "periodo" : "00-24",
                    "descripcion" : "Cubierto con lluvia"
                  }, {
                    "value" : "26",
                    "periodo" : "00-12",
                    "descripcion" : "Cubierto con lluvia"
                  }, {
                    "value" : "26",
                    "periodo" : "12-24",
                    "descripcion" : "Cubierto con lluvia"
                  } ],
                  "viento" : [ {
                    "direccion" : "S",
                    "velocidad" : 15,
                    "periodo" : "00-24"
                  }, {
                    "direccion" : "S",
                    "velocidad" : 15,
                    "periodo" : "00-12"
                  }, {
                    "direccion" : "S",
                    "velocidad" : 15,
                    "periodo" : "12-24"
                  } ],
                  "rachaMax" : [ {
                    "value" : "",
                    "periodo" : "00-24"
                  }, {
                    "value" : "",
                    "periodo" : "00-12"
                  }, {
                    "value" : "",
                    "periodo" : "12-24"
                  } ],
                  "temperatura" : {
                    "maxima" : 12,
                    "minima" : 4,
                    "dato" : [ ]
                  },
                  "sensTermica" : {
                    "maxima" : 12,
                    "minima" : 4,
                    "dato" : [ ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 90,
                    "minima" : 65,
                    "dato" : [ ]
                  },
                  "uvMax" : 1,
                  "fecha" :""" + "\"" + LocalDateTime.now().toLocalDate().plusDays(3).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 55
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "1400"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "44",
                    "descripcion" : "Nuboso con lluvia escasa"
                  } ],
                  "viento" : [ {
                    "direccion" : "NE",
                    "velocidad" : 5
                  } ],
                  "rachaMax" : [ {
                    "value" : ""
                  } ],
                  "temperatura" : {
                    "maxima" : 11,
                    "minima" : 3,
                    "dato" : [ ]
                  },
                  "sensTermica" : {
                    "maxima" : 11,
                    "minima" : 3,
                    "dato" : [ ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 90,
                    "minima" : 70,
                    "dato" : [ ]
                  },
                  "uvMax" : 1,
                  "fecha" :""" + "\"" + LocalDateTime.now().toLocalDate().plusDays(4).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 60
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "1200"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "43",
                    "descripcion" : "Intervalos nubosos con lluvia escasa"
                  } ],
                  "viento" : [ {
                    "direccion" : "C",
                    "velocidad" : 0
                  } ],
                  "rachaMax" : [ {
                    "value" : ""
                  } ],
                  "temperatura" : {
                    "maxima" : 11,
                    "minima" : 0,
                    "dato" : [ ]
                  },
                  "sensTermica" : {
                    "maxima" : 11,
                    "minima" : 0,
                    "dato" : [ ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 80,
                    "minima" : 65,
                    "dato" : [ ]
                  },
                  "fecha" :""" + "\"" + LocalDateTime.now().toLocalDate().plusDays(5).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                }, {
                  "probPrecipitacion" : [ {
                    "value" : 80
                  } ],
                  "cotaNieveProv" : [ {
                    "value" : "1300"
                  } ],
                  "estadoCielo" : [ {
                    "value" : "26",
                    "descripcion" : "Cubierto con lluvia"
                  } ],
                  "viento" : [ {
                    "direccion" : "S",
                    "velocidad" : 5
                  } ],
                  "rachaMax" : [ {
                    "value" : ""
                  } ],
                  "temperatura" : {
                    "maxima" : 8,
                    "minima" : 6,
                    "dato" : [ ]
                  },
                  "sensTermica" : {
                    "maxima" : 8,
                    "minima" : 6,
                    "dato" : [ ]
                  },
                  "humedadRelativa" : {
                    "maxima" : 100,
                    "minima" : 75,
                    "dato" : [ ]
                  },
                  "fecha" : """ + "\"" + LocalDateTime.now().toLocalDate().plusDays(6).atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                } ]
              },
              "id" : 28079,
              "version" : 1.0
            } ]
            """;

    public static final String AEMET_PREDICCION_MUNICIPIO_WITHOUT_DATA =
            """
            [
              {
                "origen" : {
                  "productor" : "Agencia Estatal de Meteorología - AEMET. Gobierno de España",
                  "web" : "https://www.aemet.es",
                  "enlace" : "https://www.aemet.es/es/eltiempo/prediccion/municipios/madrid-id28079",
                  "language" : "es",
                  "copyright" : "© AEMET. Autorizado el uso de la información y su reproducción citando a AEMET como autora de la misma.",
                  "notaLegal" : "https://www.aemet.es/es/nota_legal"
                },
                "elaborado" :"""
                    + "\"" + LocalDateTime.now().toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                ,
                "nombre" : "Madrid",
                "provincia" : "Madrid",
                "prediccion" : {
                  "dia" : [
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 0,
                          "periodo" : "00-24"
                        },
                        {
                          "value" : 0,
                          "periodo" : "00-12"
                        },
                        {
                          "value" : 0,
                          "periodo" : "12-24"
                        },
                        {
                          "value" : 0,
                          "periodo" : "00-06"
                        },
                        {
                          "value" : 0,
                          "periodo" : "06-12"
                        },
                        {
                          "value" : 0,
                          "periodo" : "12-18"
                        },
                        {
                          "value" : 0,
                          "periodo" : "18-24"
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-06"
                        },
                        {
                          "value" : "",
                          "periodo" : "06-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-18"
                        },
                        {
                          "value" : "",
                          "periodo" : "18-24"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "",
                          "periodo" : "00-24",
                          "descripcion" : ""
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12",
                          "descripcion" : ""
                        },
                        {
                          "value" : "12",
                          "periodo" : "12-24",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-06",
                          "descripcion" : ""
                        },
                        {
                          "value" : "12",
                          "periodo" : "06-12",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "12",
                          "periodo" : "12-18",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "17n",
                          "periodo" : "18-24",
                          "descripcion" : "Nubes altas"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "",
                          "velocidad" : 0,
                          "periodo" : "00-24"
                        },
                        {
                          "direccion" : "",
                          "velocidad" : 0,
                          "periodo" : "00-12"
                        },
                        {
                          "direccion" : "NO",
                          "velocidad" : 5,
                          "periodo" : "12-24"
                        },
                        {
                          "direccion" : "NO",
                          "velocidad" : 10,
                          "periodo" : "00-06"
                        },
                        {
                          "direccion" : "C",
                          "velocidad" : 0,
                          "periodo" : "06-12"
                        },
                        {
                          "direccion" : "NO",
                          "velocidad" : 5,
                          "periodo" : "12-18"
                        },
                        {
                          "direccion" : "NE",
                          "velocidad" : 5,
                          "periodo" : "18-24"
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-06"
                        },
                        {
                          "value" : "",
                          "periodo" : "06-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-18"
                        },
                        {
                          "value" : "",
                          "periodo" : "18-24"
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 10,
                        "minima" : 3,
                        "dato" : [
                          {
                            "value" : 5,
                            "hora" : 6
                          },
                          {
                            "value" : 8,
                            "hora" : 12
                          },
                          {
                            "value" : 7,
                            "hora" : 18
                          },
                          {
                            "value" : 2,
                            "hora" : 24
                          }
                        ]
                      },
                      "sensTermica" : {
                        "maxima" : 10,
                        "minima" : 2,
                        "dato" : [
                          {
                            "value" : 3,
                            "hora" : 6
                          },
                          {
                            "value" : 8,
                            "hora" : 12
                          },
                          {
                            "value" : 7,
                            "hora" : 18
                          },
                          {
                            "value" : 2,
                            "hora" : 24
                          }
                        ]
                      },
                      "humedadRelativa" : {
                        "maxima" : 80,
                        "minima" : 55,
                        "dato" : [
                          {
                            "value" : 70,
                            "hora" : 6
                          },
                          {
                            "value" : 55,
                            "hora" : 12
                          },
                          {
                            "value" : 60,
                            "hora" : 18
                          },
                          {
                            "value" : 80,
                            "hora" : 24
                          }
                        ]
                      },
                      "uvMax" : 1,
                      "fecha" : """
                    + "\"" + LocalDateTime.now().toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 0,
                          "periodo" : "00-24"
                        },
                        {
                          "value" : 0,
                          "periodo" : "00-12"
                        },
                        {
                          "value" : 0,
                          "periodo" : "12-24"
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-06"
                        },
                        {
                          "value" : "",
                          "periodo" : "06-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-18"
                        },
                        {
                          "value" : "",
                          "periodo" : "18-24"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "12",
                          "periodo" : "00-24",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "11",
                          "periodo" : "00-12",
                          "descripcion" : "Despejado"
                        },
                        {
                          "value" : "12",
                          "periodo" : "12-24",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "12n",
                          "periodo" : "00-06",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "11",
                          "periodo" : "06-12",
                          "descripcion" : "Despejado"
                        },
                        {
                          "value" : "12",
                          "periodo" : "12-18",
                          "descripcion" : "Poco nuboso"
                        },
                        {
                          "value" : "17n",
                          "periodo" : "18-24",
                          "descripcion" : "Nubes altas"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "S",
                          "velocidad" : 5,
                          "periodo" : "00-24"
                        },
                        {
                          "direccion" : "NE",
                          "velocidad" : 10,
                          "periodo" : "00-12"
                        },
                        {
                          "direccion" : "SO",
                          "velocidad" : 10,
                          "periodo" : "12-24"
                        },
                        {
                          "direccion" : "NE",
                          "velocidad" : 10,
                          "periodo" : "00-06"
                        },
                        {
                          "direccion" : "S",
                          "velocidad" : 5,
                          "periodo" : "06-12"
                        },
                        {
                          "direccion" : "SO",
                          "velocidad" : 10,
                          "periodo" : "12-18"
                        },
                        {
                          "direccion" : "C",
                          "velocidad" : 0,
                          "periodo" : "18-24"
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-06"
                        },
                        {
                          "value" : "",
                          "periodo" : "06-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-18"
                        },
                        {
                          "value" : "",
                          "periodo" : "18-24"
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 10,
                        "minima" : 2,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 11,
                        "minima" : 3,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 100,
                        "minima" : 75,
                        "dato" : []
                      },
                      "uvMax" : 1,
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 10,
                          "periodo" : "00-24"
                        },
                        {
                          "value" : 5,
                          "periodo" : "00-12"
                        },
                        {
                          "value" : 0,
                          "periodo" : "12-24"
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "1700",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "16",
                          "periodo" : "00-24",
                          "descripcion" : "Cubierto"
                        },
                        {
                          "value" : "16",
                          "periodo" : "00-12",
                          "descripcion" : "Cubierto"
                        },
                        {
                          "value" : "15",
                          "periodo" : "12-24",
                          "descripcion" : "Muy nuboso"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "C",
                          "velocidad" : 0,
                          "periodo" : "00-24"
                        },
                        {
                          "direccion" : "C",
                          "velocidad" : 0,
                          "periodo" : "00-12"
                        },
                        {
                          "direccion" : "C",
                          "velocidad" : 0,
                          "periodo" : "12-24"
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 11,
                        "minima" : 3,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 11,
                        "minima" : 3,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 100,
                        "minima" : 75,
                        "dato" : []
                      },
                      "uvMax" : 1,
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(2).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 80,
                          "periodo" : "00-24"
                        },
                        {
                          "value" : 60,
                          "periodo" : "00-12"
                        },
                        {
                          "value" : 80,
                          "periodo" : "12-24"
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "1600",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "1500",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "1800",
                          "periodo" : "12-24"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "26",
                          "periodo" : "00-24",
                          "descripcion" : "Cubierto con lluvia"
                        },
                        {
                          "value" : "26",
                          "periodo" : "00-12",
                          "descripcion" : "Cubierto con lluvia"
                        },
                        {
                          "value" : "26",
                          "periodo" : "12-24",
                          "descripcion" : "Cubierto con lluvia"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "S",
                          "velocidad" : 15,
                          "periodo" : "00-24"
                        },
                        {
                          "direccion" : "S",
                          "velocidad" : 15,
                          "periodo" : "00-12"
                        },
                        {
                          "direccion" : "S",
                          "velocidad" : 15,
                          "periodo" : "12-24"
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : "",
                          "periodo" : "00-24"
                        },
                        {
                          "value" : "",
                          "periodo" : "00-12"
                        },
                        {
                          "value" : "",
                          "periodo" : "12-24"
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 12,
                        "minima" : 4,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 12,
                        "minima" : 4,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 90,
                        "minima" : 65,
                        "dato" : []
                      },
                      "uvMax" : 1,
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(3).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 55
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "1400"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "44",
                          "descripcion" : "Nuboso con lluvia escasa"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "NE",
                          "velocidad" : 5
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : ""
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 11,
                        "minima" : 3,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 11,
                        "minima" : 3,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 90,
                        "minima" : 70,
                        "dato" : []
                      },
                      "uvMax" : 1,
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(4).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 60
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "1200"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "43",
                          "descripcion" : "Intervalos nubosos con lluvia escasa"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "C",
                          "velocidad" : 0
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : ""
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 11,
                        "minima" : 0,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 11,
                        "minima" : 0,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 80,
                        "minima" : 65,
                        "dato" : []
                      },
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(5).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    },
                    {
                      "probPrecipitacion" : [
                        {
                          "value" : 80
                        }
                      ],
                      "cotaNieveProv" : [
                        {
                          "value" : "1300"
                        }
                      ],
                      "estadoCielo" : [
                        {
                          "value" : "26",
                          "descripcion" : "Cubierto con lluvia"
                        }
                      ],
                      "viento" : [
                        {
                          "direccion" : "S",
                          "velocidad" : 5
                        }
                      ],
                      "rachaMax" : [
                        {
                          "value" : ""
                        }
                      ],
                      "temperatura" : {
                        "maxima" : 8,
                        "minima" : 6,
                        "dato" : []
                      },
                      "sensTermica" : {
                        "maxima" : 8,
                        "minima" : 6,
                        "dato" : []
                      },
                      "humedadRelativa" : {
                        "maxima" : 100,
                        "minima" : 75,
                        "dato" : []
                      },
                      "fecha" : """
                    + "\"" + LocalDateTime.now().plusDays(6).toLocalDate().atStartOfDay().format(DATE_TIME_FORMAT) + "\"" +
                    """
                    }
                  ]
                },
                "id" : 28079,
                "version" : 1.0
              }
            ]
            """;
}