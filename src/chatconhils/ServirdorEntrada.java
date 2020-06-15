/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatconhils;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class ServirdorEntrada extends Thread {
    
    
    DataInputStream din;
    String s = "";

    public ServirdorEntrada(DataInputStream in) {
        this.din = in;
    }

    @Override
    public void run() {
        try {
            while(!"QUIT".equals(s)){
                
                s = din.readUTF();
            System.out.println(s);
            }
            
                                   
        } catch (IOException ex) {
            Logger.getLogger(ServirdorEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
