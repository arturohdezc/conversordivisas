package com.aluracursos.conversormonedas.modulos;

import java.util.Map;

public record DatosRaw(String base_code,
                       Map<String, Double> conversion_rates)  {
}
