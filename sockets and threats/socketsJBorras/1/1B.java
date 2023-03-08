import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ex1B {

    public static void main(String[] args) {

        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 5000;
        DataInputStream is;
        DataOutputStream os;

        try {

            server = new ServerSocket(port);

            System.out.println("servidor iniciado");

            sc = server.accept();
            System.out.println("entrada de cliente");

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            System.out.println("recibir documento");
            String data = is.readUTF();

            System.out.println(data);

            os.writeUTF("recibido");

            escribirFichero(data);

            sc.close();
            System.out.println("cliente desconectado");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void escribirFichero(String data) throws IOException {
        File file = new File("hello.txt");

        //crear fitxer
        file.createNewFile();

        FileWriter writer = new FileWriter(file);

        writer.write(data);
        writer.flush();
        writer.close();

    }

}
