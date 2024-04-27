/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class Tiempo extends Magnitud {
    public Tiempo(String nombre, String unidad, float valor) {
        super(nombre, unidad, valor);
    }
    
    // otros metodos
    // metodo para calcular el tiempo utilizando la forma 1
    public float calcularForma1(float vi, float vf, float a) {
        return (vf - vi) / a;
    }

    // metodo para calcular el tiempo utilizando la forma 2
    public float calcularForma2(float a, float vf, float r) {
        return (vf - (float) Math.sqrt(vf * vf - 2 * a * r)) / a;
    }

    // metodo para calcular el tiempo utilizando la forma 3
    public float calcularForma3(float vi, float vf, float r) {
        return 2 * r / (vi + vf);
    }
}
