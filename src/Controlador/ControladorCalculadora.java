package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaCalculadora;

// importamos modelos
import Modelo.VelocidadInicial;
import Modelo.VelocidadFinal;
import Modelo.Tiempo;
import Modelo.Recorrido;
import Modelo.Aceleracion;
import Modelo.Magnitud;

// importamos estructuras de datos
import java.util.ArrayList;
import java.util.Collection;

public class ControladorCalculadora implements ActionListener {
    // atributos
    private VistaCalculadora vista;
    private VelocidadInicial vtInicial;
    private VelocidadFinal vtFinal;
    private Tiempo tiempo;
    private Aceleracion aceleracionTangencial;
    private Recorrido espacioRecorrido;
    private VelocidadInicial wInicial;
    private VelocidadFinal wFinal;
    private Aceleracion aceleracionAngular;
    private Recorrido anguloRecorrido;
    private ArrayList<Magnitud> magnitudesIncognitas = new ArrayList<>();
    private ArrayList<Magnitud> magnitudesConocidas = new ArrayList<>();
    
    // constructor
    public ControladorCalculadora(VistaCalculadora vista) {
        // iniciamos los atributos
        this.vista = vista;
        this.vtInicial = new VelocidadInicial("Velocidad Tangencial Inicial", "m/s", 0);
        this.vtFinal = new VelocidadFinal("Velocidad Tangencial Final", "m/s", 0);
        this.tiempo = new Tiempo("Tiempo", "s", 0);
        this.aceleracionTangencial = new Aceleracion("Aceleración Tangencial", "m/s^2", 0);
        this.espacioRecorrido = new Recorrido("Espacio Recorrido", "m", 0);
        this.wInicial = new VelocidadInicial("Velocidad Angular Inicial", "rad/s", 0);
        this.wFinal = new VelocidadFinal("Velocidad Angular Final", "rad/s", 0);
        this.aceleracionAngular = new Aceleracion("Aceleración Angular", "rad/s^2", 0);
        this.anguloRecorrido = new Recorrido("Ángulo Recorrido", "rad", 0);
    }
    
    // metodos
    public VistaCalculadora getVista() {
        return this.vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBotonCalcular()) {
            actualizarClasificarMagnitudes();
            calcularMagnitudesIncognitas();
            mostrarResultados();
        }
    }

    private boolean esNumero(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static <T> boolean contieneTodos(Collection<T> coleccion, T... elementos) {
        for (T elemento : elementos) {
            if (!coleccion.contains(elemento)) {
                return false;
            }
        }
        return true;
    }

    private void actualizarClasificarMagnitudes() {
        String vi = vista.getEntradaVi().getText();
        String vf = vista.getEntradaVf().getText();
        String t = vista.getEntradaT().getText();
        String er = vista.getEntradaEr().getText();
        String at = vista.getEntradaAt().getText();
        String wi = vista.getEntradaWi().getText();
        String wf = vista.getEntradaWf().getText();
        String ar = vista.getEntradaAr().getText();
        String aa = vista.getEntradaAa().getText();

        if (esNumero(vi)) {
            if (vi.isEmpty()) {
                this.magnitudesIncognitas.add(this.vtInicial);
            } else {
                vtInicial.setValor(Float.parseFloat(vi));
                this.magnitudesConocidas.add(this.vtInicial);
            }
        } 

        if (esNumero(vf)) {
            if (vf.isEmpty()) {
                this.magnitudesIncognitas.add(this.vtFinal);
            } else {
                this.vtFinal.setValor(Float.parseFloat(vf));
                this.magnitudesConocidas.add(this.vtFinal);
            }
        } 

        if (esNumero(t)) {
            if (t.isEmpty()) {
                this.magnitudesIncognitas.add(this.tiempo);
            } else {
                this.tiempo.setValor(Float.parseFloat(t));
                this.magnitudesConocidas.add(this.tiempo);
            }
        }

        if (esNumero(at)) {
            if (at.isEmpty()) {
                this.magnitudesIncognitas.add(this.tiempo);
            } else {
                this.tiempo.setValor(Float.parseFloat(at));
                this.magnitudesConocidas.add(this.tiempo);
            }
        } 

        if (esNumero(er)) {
            if (er.isEmpty()) {
                this.magnitudesIncognitas.add(this.espacioRecorrido);
            } else {
                this.espacioRecorrido.setValor(Float.parseFloat(er));
                this.magnitudesConocidas.add(this.espacioRecorrido);
            }
        }

        if (esNumero(wi)) {
            if (wi.isEmpty()) {
                this.magnitudesIncognitas.add(this.wInicial);
            } else {
                this.wInicial.setValor(Float.parseFloat(wi));
                this.magnitudesConocidas.add(this.wInicial);
            }
        }

        if (esNumero(wf)) {
            if (wf.isEmpty()) {
                this.magnitudesIncognitas.add(this.wFinal);
            } else {
                this.wFinal.setValor(Float.parseFloat(wf));
                this.magnitudesConocidas.add(this.wFinal);
            }
        }

        if (esNumero(aa)) {
            if (aa.isEmpty()) {
                this.magnitudesIncognitas.add(this.aceleracionAngular);
            } else {
                this.aceleracionAngular.setValor(Float.parseFloat(aa));
                this.magnitudesConocidas.add(this.aceleracionAngular);
            }
        }

        if (esNumero(ar)) {
            if (ar.isEmpty()) {
                this.magnitudesIncognitas.add(this.anguloRecorrido);
            } else {
                this.anguloRecorrido.setValor(Float.parseFloat(ar));
                this.magnitudesConocidas.add(this.anguloRecorrido);
            }
        }
    }

    private void calcularMagnitudesIncognitas() {
        String resultado = "null";
        for (Magnitud magnitud : this.magnitudesIncognitas) {
            if (magnitud == this.vtInicial) {
                resultado = calcularVtInicial();
            } else if (magnitud == this.vtFinal) {
                resultado = calcularVtFinal();
            } else if (magnitud == this.tiempo) {
                resultado = calcularTiempo();
            } else if (magnitud == this.aceleracionTangencial) {
                resultado = calcularAceleracionTangencial();
            } else if (magnitud == this.espacioRecorrido) {
                resultado = calcularEspacioRecorrido();
            } else if (magnitud == this.wInicial) {
                resultado = calcularWInicial();
            } else if (magnitud == this.wFinal) {
                resultado = calcularWFinal();
            } else if (magnitud == this.aceleracionAngular) {
                resultado = calcularAceleracionAngular();
            } else if (magnitud == this.anguloRecorrido) {
                resultado = calcularAnguloRecorrido();
            }
            
            if (!"null".equals(resultado)) {
                magnitud.setValor(Float.parseFloat(resultado));
                this.magnitudesConocidas.add(magnitud);
            }
        }
    }

    private String calcularVtInicial() {
        String result;
        if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.vtFinal, this.tiempo)) {
            result = Float.toString(this.vtInicial.calcularForma1(this.aceleracionTangencial.getValor(), this.vtFinal.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.espacioRecorrido, this.tiempo)) {
            result = Float.toString(this.vtInicial.calcularForma2(this.aceleracionTangencial.getValor(), this.espacioRecorrido.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.vtFinal, this.espacioRecorrido)) {
            result = Float.toString(this.vtInicial.calcularForma3(this.aceleracionTangencial.getValor(), this.vtFinal.getValor(), this.espacioRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtFinal, this.espacioRecorrido, this.tiempo)) {
            result = Float.toString(this.vtInicial.calcularForma4(this.vtFinal.getValor(), this.espacioRecorrido.getValor(), this.tiempo.getValor()));
        } else {
            result = "null";
        }
        return result;
    }

    private String calcularVtFinal() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.vtInicial, this.tiempo)) {
            resultado = Float.toString(this.vtFinal.calcularForma1(this.aceleracionTangencial.getValor(), this.vtInicial.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.vtInicial, this.espacioRecorrido)) {
            resultado = Float.toString(this.vtFinal.calcularForma2(this.aceleracionTangencial.getValor(), this.vtInicial.getValor(), this.espacioRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.espacioRecorrido, this.tiempo)) {
            resultado = Float.toString(this.vtFinal.calcularForma3(this.vtInicial.getValor(), this.espacioRecorrido.getValor(), this.tiempo.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }

    private String calcularAceleracionTangencial() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma1(this.vtInicial.getValor(), this.vtFinal.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.espacioRecorrido, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma2(this.vtInicial.getValor(), this.espacioRecorrido.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.espacioRecorrido)) {
            resultado = Float.toString(this.wInicial.calcularForma3(this.vtInicial.getValor(), this.vtFinal.getValor(), this.espacioRecorrido.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }
    
    private String calcularEspacioRecorrido() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.aceleracionTangencial, this.tiempo)){
            resultado = Float.toString(this.wInicial.calcularForma1(this.vtInicial.getValor(), this.aceleracionTangencial.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.aceleracionTangencial)){
            resultado = Float.toString(this.wInicial.calcularForma2(this.vtInicial.getValor(), this.vtFinal.getValor(), this.aceleracionTangencial.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.tiempo)){
            resultado = Float.toString(this.wInicial.calcularForma3(this.vtInicial.getValor(), this.vtFinal.getValor(), this.tiempo.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }

    private String calcularWInicial() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.wFinal, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma1(this.aceleracionAngular.getValor(), this.wFinal.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.anguloRecorrido, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma2(this.aceleracionAngular.getValor(), this.anguloRecorrido.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.wFinal, this.anguloRecorrido)) {
            resultado = Float.toString(this.wInicial.calcularForma3(this.aceleracionAngular.getValor(), this.wFinal.getValor(), this.anguloRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wFinal, this.anguloRecorrido, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma4(this.wFinal.getValor(), this.anguloRecorrido.getValor(), this.tiempo.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }

    private String calcularWFinal() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.wInicial, this.tiempo)) {
            resultado = Float.toString(this.wFinal.calcularForma1(this.aceleracionAngular.getValor(), this.wInicial.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.wInicial, this.anguloRecorrido)) {
            resultado = Float.toString(this.wFinal.calcularForma2(this.aceleracionAngular.getValor(), this.wInicial.getValor(), this.anguloRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.anguloRecorrido, this.tiempo)) {
            resultado = Float.toString(this.wFinal.calcularForma3(this.wInicial.getValor(), this.anguloRecorrido.getValor(), this.tiempo.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }
    
    private String calcularAceleracionAngular() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma1(this.wInicial.getValor(), this.wFinal.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.anguloRecorrido, this.tiempo)) {
            resultado = Float.toString(this.wInicial.calcularForma2(this.wInicial.getValor(), this.anguloRecorrido.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.anguloRecorrido)) {
            resultado = Float.toString(this.wInicial.calcularForma3(this.wInicial.getValor(), this.wFinal.getValor(), this.anguloRecorrido.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }
    
    private String calcularAnguloRecorrido() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.aceleracionAngular, this.tiempo)){
            resultado = Float.toString(this.wInicial.calcularForma1(this.wInicial.getValor(), this.aceleracionAngular.getValor(), this.tiempo.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.aceleracionAngular)){
            resultado = Float.toString(this.wInicial.calcularForma2(this.wInicial.getValor(), this.wFinal.getValor(), this.aceleracionAngular.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.tiempo)){
            resultado = Float.toString(this.wInicial.calcularForma3(this.wInicial.getValor(), this.wFinal.getValor(), this.tiempo.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }

    private String calcularTiempo() {
        String resultado;
        if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.aceleracionTangencial)) {
            resultado = Float.toString(tiempo.calcularForma1(this.vtInicial.getValor(), this.vtFinal.getValor(), this.aceleracionTangencial.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionTangencial, this.vtFinal, this.espacioRecorrido)) {
            resultado = Float.toString(tiempo.calcularForma2(this.aceleracionTangencial.getValor(), this.vtFinal.getValor(), this.espacioRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.vtInicial, this.vtFinal, this.espacioRecorrido)) {
            resultado = Float.toString(tiempo.calcularForma3(this.vtInicial.getValor(), this.vtFinal.getValor(), this.espacioRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.aceleracionAngular)) {
            resultado = Float.toString(tiempo.calcularForma1(this.wInicial.getValor(), this.wFinal.getValor(), this.aceleracionAngular.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.aceleracionAngular, this.wFinal, this.anguloRecorrido)) {
            resultado = Float.toString(tiempo.calcularForma2(this.aceleracionAngular.getValor(), this.wFinal.getValor(), this.anguloRecorrido.getValor()));
        } else if (contieneTodos(this.magnitudesConocidas, this.wInicial, this.wFinal, this.anguloRecorrido)) {
            resultado = Float.toString(tiempo.calcularForma3(this.wInicial.getValor(), this.wFinal.getValor(), this.anguloRecorrido.getValor()));
        } else {
            resultado = "null";
        }
        return resultado;
    }
    
    
    private void mostrarResultados(){
        String nuevoContenido = "";
        for (Magnitud magnitud : this.magnitudesIncognitas) {
            nuevoContenido += magnitud.getNombre()+ ": " + magnitud.getValor() + " " + magnitud.getUnidad() + "\n";
        }
        limpiarTextAreaResultado();
        this.vista.getTextAreaResultado().setText(nuevoContenido);
    }
    
    private void limpiarTextAreaResultado() {
        this.vista.getTextAreaResultado().setText("");
    }           
}
