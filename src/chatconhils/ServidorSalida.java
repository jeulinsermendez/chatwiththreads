/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatconhils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class ServidorSalida extends Thread {

    DataOutputStream dos;
    Scanner sc;
    String entradaTeclat ="";

    public ServidorSalida(DataOutputStream dos) {
        this.dos = dos;
    }

    @Override
    public void run() {
        try {

            sc = new Scanner(System.in);
            while (!"QUIT".equals(entradaTeclat)) {
                entradaTeclat = sc.nextLine();
                dos.writeUTF(entradaTeclat); 
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
