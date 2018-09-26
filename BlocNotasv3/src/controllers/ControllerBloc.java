/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.management.Query.lt;
import javax.swing.JFileChooser;
import models.ModelBloc;
import views.ViewBloc;
import extras.DataValidation;
/**
 *
 * @author fanny
 */
public class ControllerBloc {
   ModelBloc modelBloc;
   ViewBloc blocNotas;
    DataValidation dataValidation = new DataValidation ();
    ActionListener al = new ActionListener (){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==blocNotas.jmabrir){
                System.out.println("e.getSource()==blocNotas.jmleer");
                 jmleer_action_performed();
            }
            else if(e.getSource()==blocNotas.jmguardar){
                System.out.println("e.getSource()==blocNotas.jmguardar");
                jmguardar_action_performed();
            }
             else if(e.getSource()==blocNotas.jmcifrar){
                System.out.println("e.getSource()==blocNotas.jmcifrar");
                jmcifrar_action_performed();
            }
             else if(e.getSource()==blocNotas.jmdescifrar){
                System.out.println("e.getSource()==blocNotas.jmdescifrar");
                jmdescifrar_action_performed();
            }
        }

      
    };
    
    public ControllerBloc(ModelBloc modelBloc, ViewBloc blocNotas){
        blocNotas.setVisible(true);
        this.modelBloc = modelBloc;
        this.blocNotas = blocNotas;
        this.blocNotas.jmabrir.addActionListener(al);
        this.blocNotas.jmguardar.addActionListener(al);
        this.blocNotas.jmcifrar.addActionListener(al);
        this.blocNotas.jmdescifrar.addActionListener(al);
    }
       private void jmleer_action_performed()  { //llama al metodo para leer un archivo                      
          this.readFile();
    }                  
      private void jmguardar_action_performed() {                                      
           this.writeFile(blocNotas.jta_contenido.getText());//llama al metodo para añidir texto al final del texto 
 
     
      }
            private void jmcifrar_action_performed()  {                                      
          this.Cifrado();//llama al metodo para cifrar un texto 
    }                  
      private void jmdescifrar_action_performed() {                                      
           this.Descifrado();  //llama al metodo para descifrar un texto 
}
      /**
       * metodo para sobreescribir una linea en un archivo
       * 
       * @param message
       * @return 
       */
      public String writeFile( String message){ 
          try{
              JFileChooser file = new JFileChooser();
                  file.showSaveDialog(blocNotas.jta_contenido);
                  File guardar =file.getSelectedFile();
                  if(guardar !=null){
                  FileWriter save = new FileWriter(guardar);
                  save.write(message);
                  save.close();
                  JOptionPane.showMessageDialog(null,"El archivo fue guardado con Exito");
                  }
             
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"FILE NOT FOUND"+e.getMessage());
                  }
          return null;
          } 
      /**
       * este metodo sirve para leer un archivo buscandolo desde un menu pudiendo elegir el archivo 
       * @return 
       */
    private String readFile() {
         try{
              String row;//fila 
              
              try {
                  JFileChooser fileChooser = new JFileChooser();
                  int selector =fileChooser.showOpenDialog(blocNotas.jta_contenido);
                  File archivo =fileChooser.getSelectedFile();
                  if(archivo !=null){
                      FileReader archivos = new FileReader(archivo);
                  
                   BufferedReader bufferedReader = new BufferedReader(archivos);
                  while ((row = bufferedReader.readLine()) != null){
                      
                      blocNotas.jta_contenido.setText(row);
                      
                  }
                  bufferedReader.close();
              }
              }catch(FileNotFoundException err){
              JOptionPane.showMessageDialog(null,"FILE NOT FOUND"+err.getMessage());
              }
          }catch(IOException err){
             JOptionPane.showMessageDialog(null,"ERROR ON I/O OPERATION"+err.getMessage());
      }
          return null;
    }
    /**
     * este metodo sirve para realizar un cifrado a un texto y el usuario determinara el numero que servira para clave de cifrado 
     * como referencia para cifrar el texto utilizara el codigo ascii tomando el valor de cada letra que contenga un archivo 
     * @return 
     */
   public String Cifrado(){
       char[] array;//almacena por letras el texto que se almacena 
       modelBloc.setNumero_usuario(dataValidation.String2Int(blocNotas.jtfcifrado.getText()));//el usuario puede dar un numero para cifrar
       modelBloc.setTexto_inicial(blocNotas.jta_contenido.getText());
       array = modelBloc.getTexto_inicial().toCharArray();//convierte el texto inicial en un arreglo
       for(int x = 0; x<array.length; x++){//la variable x inicira en 0 hasta el valor que se encuentre en el array
           array[x]= (char)(array[x]+(char)modelBloc.getNumero_usuario());
       }
       modelBloc.setDesencriptar(String.valueOf(array));//el texto cifrado pasa a String y es almacenado 
       blocNotas.jta_contenido.setText(modelBloc.getDesencriptar());//se muestra en el area de texto el texto inicial pero encriptado 
       return null;
}
    public String Descifrado(){
       char[] array;
       modelBloc.setNumero_usuario(dataValidation.String2Int(blocNotas.jtfcifrado.getText()));
       modelBloc.setTexto_inicial(blocNotas.jta_contenido.getText());
       array = modelBloc.getResultado().toCharArray();
       for(int x = 0; x<array.length; x++){
           array[x]= (char)(array[x]-(char)modelBloc.getNumero_usuario());//hace la conversion de cada letra 
       }
       modelBloc.setDesencriptar(String.valueOf(array));//texto desifrado 
       blocNotas.jta_contenido.setText(modelBloc.getDesencriptar());
       return null;
}
   }

  



