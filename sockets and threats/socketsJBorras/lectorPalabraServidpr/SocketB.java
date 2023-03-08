import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SocketB {

    public static void main(String[] args) {

        ArrayList<String> lorem;
        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 5000;
        DataInputStream is;
        DataOutputStream os;
        int v = new Random().nextInt(99 + 1);
        String message;

        try {
            server = new ServerSocket(port);

            System.out.println("servidor iniciado");

            sc = server.accept();
            System.out.println("entrada de cliente");

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            os.writeInt(v);

            System.out.println("palabras a enviar: " + v);

            String confirma = is.readUTF();

            System.out.println(confirma);

            if (confirma.equals("OK")) {
                lorem = importLorem();
                for (int i = 1; v >= i; i++) {
                    message = lorem.get(i);
                    os.writeUTF(message);
                }
            }

            System.out.println("desconectando cliente");

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<String> importLorem() throws FileNotFoundException {
        ArrayList<String> lorem = new ArrayList<>();
        Scanner scan = new Scanner(new File(".\\lorem.txt"));
        
        while(scan.hasNextLine()){
            lorem.add(scan.next());
        }

        return lorem; 
    }


    

}
