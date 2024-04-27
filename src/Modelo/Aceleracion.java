/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Aceleracion extends Magnitud {
    // constructor
    public Aceleracion(String nombre, String unidad, float valor) {
        super(nombre, unidad, valor);
    }
    
    // metodo para calcular la aceleracion utilizando la forma 1
    public float calcularForma1(float vi, float vf, float t) {
        return (vf - vi) / t;
    }

    // metodo para calcular la aceleracion utilizando la forma 2
    public float calcularForma2(float vi, float r, float t) {
        return (2 * r - vi * t) / (t * t);
    }

    // metodo para calcular la aceleracion utilizando la forma 3
    public float calcularForma3(float vi, float vf, float r) {
        return (vf * vf - vi * vi) / (2 * r);
    }
}