/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Taller7;

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

        // Verificar que la fórmula contiene números y operadores
        // La expresión regular valida que la fórmula contiene números seguidos de operadores
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

        // Fórmula simple: "3+5"
        String formula1 = "3+5";
        String result1 = Operations.Solve(formula1);
        System.out.println("Solved Formula: " + result1);
        assertEquals("3+5=8", result1, "El cálculo de la fórmula '3+5' debería ser '8'.");

        // Fórmula con multiplicación y suma: "2*3+5"
        String formula2 = "2*3+5";
        String result2 = Operations.Solve(formula2);
        System.out.println("Solved Formula: " + result2);
        assertEquals("2*3+5=11", result2, "El cálculo de la fórmula '2*3+5' debería ser '11'.");

        // Fórmula con división y resta: "10/2-1"
        String formula3 = "10/2-1";
        String result3 = Operations.Solve(formula3);
        System.out.println("Solved Formula: " + result3);
        assertEquals("10/2-1=4", result3, "El cálculo de la fórmula '10/2-1' debería ser '4'.");

        // Fórmula con precedencia de operaciones: "3+5*2-4/2"
        String formula4 = "3+5*2-4/2";
        String result4 = Operations.Solve(formula4);
        System.out.println("Solved Formula: " + result4);
        assertEquals("3+5*2-4/2=12", result4, "El cálculo de la fórmula '3+5*2-4/2' debería ser '12'.");
    }

    /**
     * Test de Solve con fórmula vacía.
     * Verifica que se maneje correctamente una fórmula vacía.
     */
    @Test
    public void testSolveWithEmptyFormula() {
        System.out.println("Solve with Empty Formula");

        // Fórmula vacía
        String formula = "";
        String result = Operations.Solve(formula);
        System.out.println("Solved Formula: " + result);
        
        // El resultado esperado debe ser solo el "=" con 0 como resultado, ya que no hay operación
        assertEquals("=0", result, "Una fórmula vacía debería devolver '=0'.");
    }

    /**
     * Test de Solve con solo un número.
     * Verifica que una fórmula con un solo número se resuelva correctamente.
     */
    @Test
    public void testSolveWithOnlyNumber() {
        System.out.println("Solve with Only Number");

        // Fórmula con solo un número
        String formula = "123";
        String result = Operations.Solve(formula);
        System.out.println("Solved Formula: " + result);
        
        // El resultado esperado debe ser solo el número seguido de '='
        assertEquals("123=123", result, "Una fórmula con solo un número debería devolver el mismo número.");
    }
}
