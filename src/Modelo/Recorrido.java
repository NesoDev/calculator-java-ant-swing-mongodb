/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class Recorrido extends Magnitud {
    public Recorrido(String nombre, String unidad, float valor) {
        super(nombre, unidad, valor);
    }
    
    // otros metodos
    // metodo para calcular el recorrido utilizando la forma 1
    public float calcularForma1(float vi, float a, float t) {
        return vi * t + 0.5f * a * t * t;
    }

    // metodo para calcular el recorrido utilizando la forma 2
    public float calcularForma2(float vi, float vf, float a) {
        return (vf * vf - vi * vi) / (2 * a);
    }

    // netodo para calcular el recorrido utilizando la forma 3
    public float calcularForma3(float vi, float vf, float t) {
        return 0.5f * (vi + vf) * t;
    }
}