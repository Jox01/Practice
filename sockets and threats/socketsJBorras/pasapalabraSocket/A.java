import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 7;
        Socket sc;
        DataInputStream is;
        DataOutputStream os;
        Scanner scanner = new Scanner(System.in);

        try {

            sc = new Socket(host, port);

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            System.out.println("cliente iniciado");

            System.out.println("Introduce un mensaje");

            String confirma = scanner.nextLine();

            os.writeUTF(confirma);

            System.out.println("Mensaje de vuelta");

            System.out.println(is.readUTF()); 
            
            sc.close();

            System.out.println("cliente cerrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         finally {
            scanner.close();
         }
    }
}
