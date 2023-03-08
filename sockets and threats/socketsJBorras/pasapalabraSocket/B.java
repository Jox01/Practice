import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class B {
    public static void main(String[] args) {
        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 7;
        DataInputStream is;
        DataOutputStream os;
        String message;

        try {
            server = new ServerSocket(port);
            
            System.out.println("servidor iniciado");

            sc = server.accept();
            System.out.println("entrada de cliente");

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());
            
            message = is.readUTF();

            System.out.println(message);

            os.writeUTF(message);

            System.out.println("desconectando cliente");

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
