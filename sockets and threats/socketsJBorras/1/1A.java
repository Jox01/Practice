import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class ex1A {

    public static void main(String[] args) throws IOException {

        final String host = "127.0.0.1";
        final int port = 5000;
        String dataString;
        String archivo = "C:\\Users\\usuario1\\Desktop\\arxProba.txt";
        DataInputStream is;
        DataOutputStream os;
        Socket sc;

        try {

            sc = new Socket(host, port);

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            System.out.println("cogiendo archivo");
            dataString = getContenido(archivo);

            System.out.println(dataString);

            os.writeUTF(dataString);

            String respuesta = is.readUTF();

            System.out.println(respuesta);

            sc.close();

            System.out.println("cliente cerrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getContenido(String archivo) throws FileNotFoundException, IOException {
        String dataString = "";
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);

        while ((cadena = b.readLine()) != null) {

            dataString += cadena;

        }

        b.close();

        return dataString;
    }

}
