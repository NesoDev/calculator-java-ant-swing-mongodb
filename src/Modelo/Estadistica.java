/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Estadistica {

    // atributos
    private int cantUsuarioMuySatisfechos;
    private int cantUsuariosSatisfechos;
    private int cantUsuariosNeutros;
    private int cantUsuarioInsatisfechos;

    // constructor
    public Estadistica(int cantUsuarioMuySatisfechos, int cantUsuariosSatisfechos, int cantUsuariosNeutros, int cantUsuarioInsatisfechos) {
        this.cantUsuarioMuySatisfechos = cantUsuarioMuySatisfechos;
        this.cantUsuariosSatisfechos = cantUsuariosSatisfechos;
        this.cantUsuariosNeutros = cantUsuariosNeutros;
        this.cantUsuarioInsatisfechos = cantUsuarioInsatisfechos;
    }

    // metodos de acceso
    public int getCantUsuarioMuySatisfechos() {
        return cantUsuarioMuySatisfechos;
    }

    public int getCantUsuariosSatisfechos() {
        return cantUsuariosSatisfechos;
    }

    public int getCantUsuariosNeutros() {
        return cantUsuariosNeutros;
    }

    public int getCantUsuarioInsatisfechos() {
        return cantUsuarioInsatisfechos;
    }

    public void setCantUsuarioMuySatisfechos(int cantUsuarioMuySatisfechos) {
        this.cantUsuarioMuySatisfechos = cantUsuarioMuySatisfechos;
    }

    public void setCantUsuariosSatisfechos(int cantUsuariosSatisfechos) {
        this.cantUsuariosSatisfechos = cantUsuariosSatisfechos;
    }

    public void setCantUsuariosNeutros(int cantUsuariosNeutros) {
        this.cantUsuariosNeutros = cantUsuariosNeutros;
    }

    public void setCantUsuarioInsatisfechos(int cantUsuarioInsatisfechos) {
        this.cantUsuarioInsatisfechos = cantUsuarioInsatisfechos;
    }
}
