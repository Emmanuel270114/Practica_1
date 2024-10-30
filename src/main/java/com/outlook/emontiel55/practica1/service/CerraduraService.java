package com.outlook.emontiel55.practica1.service;

import java.util.ArrayList;
import java.util.List;

public class CerraduraService {

    // Método para calcular la cerradura de Kleene
    public List<String> cerraduraEstrella(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            generarCombinaciones(result, "", i);
        }
        return result;
    }

    // Método para calcular la cerradura positiva
    public List<String> cerraduraPositiva(int n) {
        List<String> result = cerraduraEstrella(n);
        result.remove(""); // Remover la cadena vacía
        return result;
    }

    // Método auxiliar para generar combinaciones binarias
    private void generarCombinaciones(List<String> result, String prefix, int length) {
        if (length == 0) {
            result.add(prefix);
        } else {
            generarCombinaciones(result, prefix + "0", length - 1);
            generarCombinaciones(result, prefix + "1", length - 1);
        }
    }
}
