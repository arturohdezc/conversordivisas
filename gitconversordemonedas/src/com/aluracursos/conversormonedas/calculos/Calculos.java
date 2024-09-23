package com.aluracursos.conversormonedas.calculos;

import com.aluracursos.conversormonedas.modulos.DatosRaw;

public class Calculos {
    public String[] ejecutarConversion (int eleccion, double cantidad, DatosRaw datosRaw){
        double data = 0;
        String monedaPrimaria= "";
        String monedaSecundaria= "";
        String dataString = "";
        switch (eleccion) {
            case 1:
                data = cantidad * datosRaw.conversion_rates().get("ARS");
                monedaPrimaria = "USD";
                monedaSecundaria = "ARS";
                break;
            case 2:
                data = cantidad / datosRaw.conversion_rates().get("ARS");
                monedaPrimaria = "ARS";
                monedaSecundaria = "USD";

                break;
            case 3:
                data = cantidad * datosRaw.conversion_rates().get("COP");
                monedaPrimaria = "USD";
                monedaSecundaria = "COP";
                break;
            case 4:
                data = cantidad / datosRaw.conversion_rates().get("COP");
                monedaPrimaria = "COP";
                monedaSecundaria = "USD";
                break;
            case 5:
                data = cantidad * datosRaw.conversion_rates().get("BRL");
                monedaPrimaria = "USD";
                monedaSecundaria = "BRL";
                break;
            case 6:
                data = cantidad / datosRaw.conversion_rates().get("BRL");
                monedaPrimaria = "BRL";
                monedaSecundaria = "USD";
                break;
                case 7:
                data = cantidad * datosRaw.conversion_rates().get("MXN");
                monedaPrimaria = "USD";
                monedaSecundaria = "MXN";
                break;
            case 8:
                data = cantidad / datosRaw.conversion_rates().get("MXN");
                monedaPrimaria = "MXN";
                monedaSecundaria = "USD";
                break;

            default:

                break;


        }
        dataString= String.valueOf(data);
        return new String[]{dataString, monedaPrimaria, monedaSecundaria};
    }
}
