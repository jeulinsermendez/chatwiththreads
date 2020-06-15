/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlos
 */
import chatconhils.ClienteEntrada;
import chatconhils.ClienteSalida;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.*;
import java.util.*;

public class ClientChat {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String entradaTeclat = "";
        String entradaSocket = "";
        ClienteEntrada entrada;
        ClienteSalida salida;

        try {
            Socket socket = new Socket("localhost", 7000);
            System.out.println("CLiente conectado");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            entrada = new ClienteEntrada(dis);
            salida = new ClienteSalida(dos);

            // LLegeixo del teclat i ho envio al socket
            entrada.start();
            salida.start();
            
            entrada.join();
            salida.join();
           

            // Un cop enviat el missatge al servidor, si no he enviat l'ordre de desconexió 
            // espero la resposta del Server i la mostro per pantalla
        } catch (SocketException ex) {
            System.out.println("Servidor desconnectat");
        }

    }

}
