/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class VelocidadInicial extends Magnitud {
    public VelocidadInicial(String nombre, String unidad, float valor) {
        super(nombre, unidad, valor);
    }
    
    // otros metodos
    // metodo para calcular la velocidad inicial utilizando la forma 1
    public float calcularForma1(float a, float vf, float t) {
        return vf - (a * t);
    }

    // metodo para calcular la velocidad inicial utilizando la forma 2
    public float calcularForma2(float a, float r, float t) {
        return (r - (0.5f * a * t * t)) / t;
    }

    // meodo para calcular la velocidad inicial utilizando la forma 3
    public float calcularForma3(float a, float vf, float r) {
        return (vf * vf) - (2 * a * r);
    }

    // metodo para calcular la velocidad inicial utilizando la forma 4
    public float calcularForma4(float vf, float r, float t) {
        return (2 * r / t) - vf;
    }
}

