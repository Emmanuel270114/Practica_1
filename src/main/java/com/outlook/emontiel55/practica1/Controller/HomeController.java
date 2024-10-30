package com.outlook.emontiel55.practica1.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cerradura")
public class HomeController {

    @GetMapping("/estrella/{input}")
    public ResponseEntity<Map<String, Object>> getCerraduraKleene(@PathVariable int input) {
        List<String> cerraduraKleene = calculateKleeneClosure(input);
        Map<String, Object> response = new HashMap<>();
        response.put("cerraduraKleene", cerraduraKleene);
        return ResponseEntity.ok(response); // Devuelve la respuesta en formato JSON
    }

    @GetMapping("/positiva/{input}")
    public ResponseEntity<Map<String, Object>> getCerraduraPositiva(@PathVariable int input) {
        List<String> cerraduraPositiva = calculatePositiveClosure(input);
        Map<String, Object> response = new HashMap<>();
        response.put("cerraduraPositiva", cerraduraPositiva);
        return ResponseEntity.ok(response); // Devuelve la respuesta en formato JSON
    }

    private List<String> calculateKleeneClosure(int n) {
        List<String> closure = new ArrayList<>();
        closure.add("λ"); // Agrega la cadena vacía
        for (int i = 0; i <= n; i++) {
            closure.addAll(generateBinaryStrings(i)); // Genera cadenas binarias de longitud i
        }
        return closure;
    }

    private List<String> calculatePositiveClosure(int n) {
        List<String> closure = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            closure.addAll(generateBinaryStrings(i)); // Genera cadenas binarias de longitud i
        }
        return closure;
    }    

    private List<String> generateBinaryStrings(int n) {
        List<String> binaryStrings = new ArrayList<>();
        int max = (int) Math.pow(2, n);
        for (int i = 0; i < max; i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < n) {
                binary = "0" + binary; // Asegura que la longitud sea n
            }
            binaryStrings.add(binary);
        }
        return binaryStrings;
    }
}
