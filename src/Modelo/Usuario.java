/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ...
 */
public class Usuario {
    // atributos
    private String username;
    private String contrasenia;
    private String email;
    private String satisfaccion;

    // constructor
    public Usuario(String username, String contrasenia, String email, String satisfaccion) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.email = email;
        this.satisfaccion = satisfaccion;
    }

    // metodos de acceso
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public String getSatisfaccion() {
        return satisfaccion;
    }

    // metodos de modificacion
    public void setUserName(String nuevoUsername) {
        this.username = nuevoUsername;
    }

    public void setPassword(String nuevaContrasenia) {
        this.contrasenia = nuevaContrasenia;
    }

    public void setEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }

    public void setSatisfaccion(String opcion) {
        this.satisfaccion = opcion;
    }
}