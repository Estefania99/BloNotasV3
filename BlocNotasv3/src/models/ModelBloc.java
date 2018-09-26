/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author fanny
 */
public class ModelBloc {
    
    String message;
    String encriptar;//almacenara el texto encriptado 
    String texto_inicial;//almacenara el texto a encriptar 
    String desencriptar;//almacenara el trexto desencriptado 
    int numero_usuario;//almacenara el numero que el usuario digite para su cifrado 

    public String getTexto_inicial() {
        return texto_inicial;
    }

    public void setTexto_inicial(String texto_inicial) {
        this.texto_inicial = texto_inicial;
    }

    public int getNumero_usuario() {
        return numero_usuario;
    }

    public void setNumero_usuario(int numero_usuario) {
        this.numero_usuario = numero_usuario;
    }

    public String getDesencriptar() {
        return desencriptar;
    }

    public void setDesencriptar(String desencriptar) {
        this.desencriptar = desencriptar;
    }

    public String getEncriptar() {
        return encriptar;
    }

    public void setEncriptar(String encriptar) {
        this.encriptar = encriptar;
    }

    public String getResultado() {
        return texto_inicial;
    }

    public void setResultado(String resultado) {
        this.texto_inicial = resultado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void descencriptar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
