/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class VelocidadFinal extends Magnitud {
    public VelocidadFinal(String nombre, String unidad, float valor) {
        super(nombre, unidad, valor);
    }
    
    // otros metodos
    // metodo para calcular la velocidad final utilizando la forma 1
    public float calcularForma1(float a, float vi, float t) {
        return vi + (a * t);
    }

    // metodo para calcular la velocidad final utilizando la forma 2
    public float calcularForma2(float a, float vi, float r) {
        return (float) Math.sqrt((vi * vi) + (2 * a * r));
    }

    // metodo para calcular la velocidad final utilizando la forma 3
    public float calcularForma3(float vi, float r, float t) {
        return (2 * r / t) - vi;
    }
}