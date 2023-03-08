
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class ex3B {

    public static void main(String[] args) throws IOException {
        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 5000;
        DataInputStream is;
        DataOutputStream os;
        ArrayList<Byte> buffer = new ArrayList<Byte>();
        boolean flag = true;


        try {
            server = new ServerSocket(port);

            System.out.println("servidor iniciado");

            sc = server.accept();
            System.out.println("entrada de cliente");

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            // leer 3 primeros luego comprobar si estos son Uep o los siguientes
            //cortar cuando encuenta el Uep en el string y contestar
            //si acaba y no encuentrar ¿avisar? 85 101 112

            buffer.add(is.readByte());
            buffer.add(is.readByte());

            
            do{
                
                byte newByte = is.readByte();
                
                //no funciona la llibraria cuan acaba
                buffer.add(newByte);
                System.out.println(newByte);
                if(buffer.get(buffer.size() - 3) == 85){ //U

                    if(buffer.get(buffer.size() - 2) == 101){ //e

                        if(buffer.get(buffer.size() - 1) == 112){ //p
                            flag = false;
                        } 
                    }
                } 

            }while(flag);

            //contesta
            
            os.writeUTF("Què tal?");

            System.out.println("desconectando cliente");

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
