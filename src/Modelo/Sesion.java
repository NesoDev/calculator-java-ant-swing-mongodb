/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class Sesion {
    // atributos
    private Usuario usuario;
    private boolean estado;

    // constructor
    public Sesion(Usuario usuario, boolean estado) {
        this.usuario = usuario;
        this.estado = estado;
    }

    // metodos de acceso
    public Usuario getUsuario() {
        return usuario;
    }

    public boolean getEstado() {
        return estado;
    }

    // metodos de modificacion
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Otros metodos
    public void reestablecerContrasenia() {
        // logica
    }

    public boolean iniciarSesion(String username, String contrasenia) {
        ConexionBD conexion = new ConexionBD("mongodb+srv://username:password@cluster.mongodb.net", "proyectoCalculadoraDB");
        try (MongoClient mongoClient = MongoClients.create(conexion)) {
            // seleccionamos la coleccion "Usuario"
            MongoDatabase database = mongoClient.getDatabase(conexion.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Usuario");

            // buscamos un documento con las mismas credenciales
            Document documentoUsuario = collection.find(Filters.and(
                Filters.eq("username", username),
                Filters.eq("contrasenia", contrasenia)
            )).first();

            if (documentoUsuario != null) {
                this.usuario = new Usuario(
                    documentoUsuario.getString("username"),
                    documentoUsuario.getString("contrasenia"),
                    documentoUsuario.getString("email"),
                    documentoUsuario.getString("satisfaccion")
                );
                this.estado = true;
                return true;
            } else {
                return false;
            }
        }
    }

    public void cerrarSesion() {
        this.estado = false;
    }

    public boolean enviarEncuesta(String usuario, String satisfaccion) {
        ConexionBD conexion = new ConexionBD("mongodb+srv://username:password@cluster.mongodb.net", "proyectoCalculadoraDB");
        try (MongoClient mongoClient = MongoClients.create(conexion)) {
            MongoDatabase database = mongoClient.getDatabase(conexion.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Usuario");

            // buscamos el documento
            Document filtro = new Document("username", usuario);
            Document actualizacion = new Document("$set", new Document("satisfaccion", satisfaccion));

            // actualizamos el documento
            collection.updateOne(filtro, actualizacion);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
