/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConexionBD {
    // atributos
    private MongoClient mongoClient;
    private MongoDatabase database;

    // constructor
    public ConexionBD(String uri, String nombreBaseDatos) {
        // Establecer la conexión a la base de datos
        this.mongoClient = MongoClients.create(new ConnectionString(uri));
        this.database = mongoClient.getDatabase(nombreBaseDatos);
    }

    // metodos
    public MongoDatabase getDatabase() {
        return this.database;
    }

    public void cerrarConexion() {
        this.mongoClient.close();
    }
}
