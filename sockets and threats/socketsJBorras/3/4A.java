import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ex4A {
    public static void main(String[] args) throws IOException {

        final String host = "127.0.0.1";
        final int port = 5000;
        String dataString = "token";
        DataInputStream is;
        DataOutputStream os;
        Socket sc;

        try {

            sc = new Socket(host, port);

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            System.out.println("cliente iniciado");

            os.writeBytes(dataString);

            String respuesta = is.readUTF();

            System.out.println("respuesta server: "+respuesta);

            sc.close();

            System.out.println("cliente cerrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
