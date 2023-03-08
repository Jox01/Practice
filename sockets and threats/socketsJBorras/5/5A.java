import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ex5A {
    public static void main(String[] args) throws IOException {

        final String host = "127.0.0.1";
        final int port = 5000;
        DataInputStream is;
        Socket sc;

        try {

            sc = new Socket(host, port);

            is = new DataInputStream(sc.getInputStream());

            System.out.println("cliente iniciado");

            String respuesta = is.readUTF();

            System.out.println("respuesta server: "+respuesta);

            sc.close();

            System.out.println("cliente cerrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
