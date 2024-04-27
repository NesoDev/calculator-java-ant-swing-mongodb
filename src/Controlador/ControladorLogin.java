package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//

// importamos vistas
import Vista.VistaLogin;

// importamos modelos
import Modelo.Sesion;
import Modelo.Usuario;

public class ControladorLogin implements ActionListener {
    private VistaLogin vista;
    private Sesion sesion;
    private String username;
    private String contrasenia;
    private Usuario usuario;
    
    // constructor
    public ControladorLogin(Sesion sesion, VistaLogin vista) {
        this.vista = vista;
        this.sesion = sesion;
        this.vista.getBotonIniciarSesion().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBotonIniciarSesion()) {
            actualizarCredenciales();
            if (auntenticarCredenciales(this.sesion)) {
                this.sesion.setEstado(true);
                this.sesion.setUsuario(this.usuario);
                this.vista.cerrarVentana();
            }
        }
    }
    
    public void actualizarCredenciales() {
        this.username = vista.getEntradaUsuario().getText();
        this.contrasenia = vista.getEntradaContrasenia().getText();
    }
    
    public boolean auntenticarCredenciales(Sesion sesion) {
        // logica de autenticacion
        // ...
        
        // cambiamos los datos
        
        // if (resultadoDeMongoDB != null) {
        // this.usuario.setUsername(resultadoDeMongoDB.usernmae)
        // this.usuario.setContrasenia(resultadoDeMongoDB.contrasenia)
        // this.usuario.setEmail(resultadoDeMongoDB.email)
        // this.usuario.setSatisfaccion(resultadoDeMongoDB.satisfccion)
        // }
        
        return (!username.isEmpty() && !contrasenia.isEmpty());
    }
}