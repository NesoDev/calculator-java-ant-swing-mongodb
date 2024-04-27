/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.FindIterable;
//import org.bson.Document;
//import Modelo.ConexionBD;

public class Administrador extends Usuario {
    // atributos
    private Estadistica ultimaEstadisticaSatisfaccion;

    // constructor
    public Administrador(String username, String contrasenia, String email, String satisfaccion) {
        super(username, contrasenia, email, satisfaccion);
    }

    // metodos de acceso
    public Estadistica getUltimaEstadisticaSatisfaccion() {
        return this.ultimaEstadisticaSatisfaccion;
    }
    
    // metodos de modificacion
    public void setUltimaEstadistica(Estadistica nuevaEstadistica) {
        this.ultimaEstadisticaSatisfaccion = nuevaEstadistica;
    }

    // otros metodos
    //public Estadistica obtenerNuevaEstadisticaSatisfaccion() {
    //    ConexionBD conexion = new ConexionBD("mongodb+srv://username:password@cluster.mongodb.net", "proyectoCalculadoraDB");
    //    MongoCollection<Document> collection = conexion.getDatabase().getCollection("Usuario");
    //    FindIterable<Document> documentosUsuarios = collection.find();
//
    //    Estadistica estadisticaSatisfaccion = new Estadistica();
    //    int cantUsuarioMuySatisfechos = 0;
    //    int cantUsuarioSatisfechos = 0;
    //    int cantUsuariosNeutros = 0;
    //    int cantUsuarioInsatisfechos = 0;
//
    //    for (Document documentoUsuario : documentosUsuarios) {
    //        String nivelSatisfaccion = documentoUsuario.getString("satisfaccion");
    //        if (nivelSatisfaccion.equals("Muy satisfecho")) {
    //            cantUsuarioMuySatisfechos += 1;
    //        } else if (nivelSatisfaccion.equals("Satisfecho")) {
    //            cantUsuarioSatisfechos += 1;
    //        } else if (nivelSatisfaccion.equals("Neutro")) {
    //            cantUsuariosNeutros += 1;
    //        } else if (nivelSatisfaccion.equals("Insatisfecho")) {
    //            cantUsuarioInsatisfechos += 1;
    //        }
    //    }
//
    //    // Configuración de la estadística
    //    estadisticaSatisfaccion.setCantUsuarioMuySatisfechos(cantUsuarioMuySatisfechos);
    //    estadisticaSatisfaccion.setCantUsuarioSatisfechos(cantUsuarioSatisfechos);
    //    estadisticaSatisfaccion.setCantUsuarioNeutros(cantUsuariosNeutros);
    //    estadisticaSatisfaccion.setCantUsuarioInsatisfechos(cantUsuarioInsatisfechos);
//
    //    // Asignar la nueva estadística al administrador
    //    this.setUltimaEstadistica(estadisticaSatisfaccion);
//
    //    return estadisticaSatisfaccion;
    //}
}

