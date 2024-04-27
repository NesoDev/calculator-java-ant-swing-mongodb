package App;

// importamos las vistas
import Vista.VistaLogin;
import Vista.VistaCalculadora;
import Vista.VistaEncuesta;

// importamos los controladores
import Controlador.ControladorLogin;
import Controlador.ControladorCalculadora;
import Controlador.ControladorEncuesta;

// importamos los modelos
import Modelo.Sesion;
import Modelo.ConexionBD;

public class App {
    
    // constuctor
    public static void main(String[] args) {
        // creamos una instancia sesion
        Sesion sesion = new Sesion();
        ConexionBD conexion = new ConexionBD();
        
        // creamos instancias de las vistas
        VistaLogin vLogin = new VistaLogin();
        VistaCalculadora vCalculadora = new VistaCalculadora();
        VistaEncuesta vEncuesta = new VistaEncuesta();
        
        // creamos instancias de los controladores
        ControladorLogin cLogin = new ControladorLogin(sesion, vLogin);
        ControladorCalculadora cCalculadora = new ControladorCalculadora(vCalculadora);
        ControladorEncuesta cEncuesta = new ControladorEncuesta(vEncuesta);
        
        // hacemos visible la vista login
        vLogin.setVisible(true);
    }
}
