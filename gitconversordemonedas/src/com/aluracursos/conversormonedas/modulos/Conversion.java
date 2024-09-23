package com.aluracursos.conversormonedas.modulos;

public record Conversion(String base_code,
                         String target_code,
                         String conversion_rate,
                         String conversion_result,
                         String cantidad_conversion,
                         String hora_actual) {

}
