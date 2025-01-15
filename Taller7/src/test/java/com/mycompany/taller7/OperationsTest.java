/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.taller7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    public OperationsTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of MakeFormula method, of class Operations.
     * Este test verifica que MakeFormula genera una fórmula con números y operadores.
     */
    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        
        String formula = Operations.MakeFormula();
        System.out.println("Generated Formula: " + formula);

        assertNotNull(formula, "La fórmula generada no debe ser null");
        assertFalse(formula.isEmpty(), "La fórmula generada no debe estar vacía");
        assertTrue(formula.matches("^[0-9]+[\\+\\-\\*/][0-9]+([\\+\\-\\*/][0-9]+)*$"),
                "La fórmula generada no tiene el formato esperado.");
    }

    /**
     * Test of Solve method, of class Operations.
     * Este test verifica que el cálculo de la fórmula sea correcto.
     */
    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula1 = "12+34";
        String result1 = Operations.Solve(formula1);
        System.out.println("Formula Resuelta: " + result1);
        assertEquals("12+34=46", result1, "El cálculo de la fórmula '12+34' debería ser '46'.");

        String formula3 = "100/25+10";
        String result3 = Operations.Solve(formula3);
        System.out.println("Formula Resuelta " + result3);
        assertEquals("100/25+10=14", result3, "El cálculo de la fórmula '100/5-10' debería ser '10'.");

        
    }

    /**
     * Test de Solve con fórmula vacía.
     * Verifica que se maneje correctamente una fórmula vacía y una cadena de caracteres.
     */
    @Test
    public void testSolveWithEmptyFormula() {
        System.out.println("Solve con una formula vacia");

        String formula = "";
        String result = Operations.Solve(formula);
        System.out.println("Formula Resuelta: " + result);
        
        assertEquals("=0", result, "Una fórmula vacía debería devolver '=0'.");
        
        System.out.println("Solve con una cadena de caracteres");
        
        String formula1 = "hola";
        String result1 = Operations.Solve(formula1);
        System.out.println("Solved Formula: " + result);
        

        assertEquals("=0", result, "Una cadena de caracteres debería lanzar una Excepcion'.");
    }

    /**
     * Test de Solve con solo un número.
     * Verifica que una fórmula con un solo número se resuelva correctamente.
     */
    @Test
    public void testSolveConUnSoloNumero() {
        System.out.println("Solve con un solo numero");

        String formula = "123";
        String result = Operations.Solve(formula);
        System.out.println("Formula Resuelta: " + result);
    
        assertEquals("123=123", result, "Una fórmula con solo un número debería devolver el mismo número.");
    }
    
    /**
     * Test de resultado diferente en Solve.
     * Verifica que el resultado de dos fórmulas diferentes no sean iguales.
     */
    @Test
    public void testSolveNotEquals() {
        System.out.println("Solve Not Equals");

        // Fórmulas diferentes
        String formula1 = "5+3";
        String formula2 = "7+1";
        String result1 = Operations.Solve(formula1);
        String result2 = Operations.Solve(formula2);
        
        assertNotEquals(result1, result2, "Los resultados de las fórmulas no deberían ser iguales.");
    }
    
    /**
     * Test de Solve con fórmula con división por cero.
     * Verifica que se lance una excepción cuando hay división por cero.
     */
    @Test
    public void testSolveWithDivisionByZero() {
        System.out.println("Solve with Division by Zero");

        // Fórmula con división por cero: "5/0"
        String formula = "51/0";
        assertThrows(ArithmeticException.class, () -> Operations.Solve(formula),
                "Se esperaba una excepción ArithmeticException por división por cero.");
    }
}
