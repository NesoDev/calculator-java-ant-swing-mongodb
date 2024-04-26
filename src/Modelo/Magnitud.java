/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class Magnitud {
    // atributos
    private String nombre;
    private String unidad;
    private float valor;

    // constructor
    public Magnitud(String nombre, String unidad, float valor) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.valor = valor;
    }

    // metodos de acceso
    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public float getValor() {
        return valor;
    }

    // Métodos de modificación
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setUnidad(String nuevaUnidad) {
        this.unidad = nuevaUnidad;
    }

    public void setValor(float nuevoValor) {
        this.valor = nuevoValor;
    }
}