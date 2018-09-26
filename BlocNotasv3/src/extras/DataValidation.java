/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import javax.swing.JOptionPane;

/**
 *
 * @author fanny
 */
public class DataValidation {
     public int String2Int(String value){
    int numero_usuario = 0;
    try{
        numero_usuario=Integer.parseInt(value);
    }catch(NumberFormatException err){
        JOptionPane.showMessageDialog(null,"Error solo numeros");
        numero_usuario=0;
    }
    return (int)numero_usuario;
    } 
}
