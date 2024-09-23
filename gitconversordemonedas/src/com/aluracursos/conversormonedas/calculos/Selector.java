package com.aluracursos.conversormonedas.calculos;

public class Selector {
    public String[] monedaRecibida (int seleccion){
        String monedaPrimaria;
        String monedaSecundaria;

        switch (seleccion) {
            case 1:
                monedaPrimaria = "USD";
                monedaSecundaria = "ARS";
                break;
            case 2:
                monedaPrimaria = "ARS";
                monedaSecundaria = "USD";
                break;
            case 3:
                monedaPrimaria = "USD";
                monedaSecundaria = "BRL";
                break;
            case 4:
                monedaPrimaria = "BRL";
                monedaSecundaria = "USD";
                break;
            case 5:
                monedaPrimaria = "USD";
                monedaSecundaria = "COP";
                break;
            case 6:
                monedaPrimaria = "COP";
                monedaSecundaria = "USD";
                break;
            case 7:
                monedaPrimaria = "USD";
                monedaSecundaria = "MXN";
                break;
            case 8:
                monedaPrimaria = "MXN";
                monedaSecundaria = "USD";
                break;

            default:
                monedaPrimaria = "USD";
                monedaSecundaria = "MXN";
                break;
        }
        return new String[]{monedaPrimaria, monedaSecundaria};
    }

}
