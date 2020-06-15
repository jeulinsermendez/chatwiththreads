/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatconhils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class ClienteSalida extends Thread {

    DataOutputStream dos;
    Scanner sc;
    String entradaTeclat;

    public ClienteSalida(DataOutputStream dos) {
        this.dos = dos;
    }

    @Override
    public void run() {
        sc = new Scanner(System.in);

        try {
            while (!"QUIT".equals(entradaTeclat)) {
                sc = new Scanner(System.in);
                entradaTeclat = sc.nextLine();
                dos.writeUTF(entradaTeclat); //To change body of generated methods, choose Tools | Templates.

            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
