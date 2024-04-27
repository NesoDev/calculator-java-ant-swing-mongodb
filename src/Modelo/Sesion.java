package Modelo;

public class Sesion {
    // atributos
    private Usuario usuario;
    private boolean estado;

    // constructor
    public Sesion() {
        this.estado = false;
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
}
