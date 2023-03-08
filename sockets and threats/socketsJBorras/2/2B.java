import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ex2B {

    public static void main(String[] args) throws IOException {
        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 5000;
        DataInputStream is;
        DataOutputStream os;

        ArrayList<Byte> buffer = new ArrayList<Byte>();
        int count = 0;

        try {
            server = new ServerSocket(port);

            System.out.println("servidor iniciado");

            sc = server.accept();
            System.out.println("entrada de cliente");

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            // leer mientras no se acabe o sea ?

            do{
                buffer.add(is.readByte()); 

                System.out.println(buffer.get(count));

                count++;

            }while (buffer.get(count-1) != 63 && buffer.get(count-1) != -1);  

            String data = new String(listToArray(buffer), "ISO-8859-1");

            System.out.println(data);

            if(data.equals("Com et dius?")){
                os.writeUTF("Em dic Exercici 2");
            }else if(data.equals("Quantes línies de codi tens?")){
                os.writeUTF("82");
            }else{
                os.writeUTF("No he entès la pregunta");
            }

            System.out.println("desconectando cliente");

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static byte[] listToArray(ArrayList<Byte> buffer) {
        
        int lenght = buffer.size();

        byte[] dataByte = new byte[lenght];

        for(int i = 0 ; lenght > i ; i ++){

            dataByte[i] = buffer.get(i);

        }

        return dataByte;

    }

}
