
import chatconhils.ServidorSalida;
import chatconhils.ServirdorEntrada;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

public class ServerChat {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String entradaTeclat = "";
        ServirdorEntrada entrada;
        ServidorSalida salida;

        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server is started");

        while (true) {

            System.out.println("Esperant nou client... ");

            Socket socket = server.accept();

            System.out.println("Client connectat: " + socket.getLocalAddress() + ":" + socket.getPort());
            String s = "";

            try {
                while (!".".equals(s)) {
                    // Espero que el client m'escrigui alguna cosa

                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    entrada = new ServirdorEntrada(din);
                    salida = new ServidorSalida(dos);

                    entrada.start();
                    
                    salida.start();
                    
                    entrada.join();
                    salida.join();

                }
            } catch (SocketException ex) {
                System.out.println("Client desconnectat");
            }

            socket.close();
        }
    }
}
