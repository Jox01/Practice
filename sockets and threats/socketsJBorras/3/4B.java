
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class ex4B {

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

            // leer 5 primeros luego comprobar si estos son token o los siguientes
            //cortar cuando encuenta el token en el string y contestar
            //116 111 107 101 110

            buffer.add(is.readByte());
            buffer.add(is.readByte());
            buffer.add(is.readByte());
            buffer.add(is.readByte());

            
            do{
                //no funciona la llibraria cuan acaba
                buffer.add(is.readByte());
                System.out.println(buffer.get(buffer.size() - 1));
                if(buffer.get(buffer.size() - 5) == 116){ //t

                    if(buffer.get(buffer.size() - 4) == 111){ //o

                        if(buffer.get(buffer.size() - 3) == 107){ //k

                            if(buffer.get(buffer.size() - 2) == 101){ //e
    
                                if(buffer.get(buffer.size() - 1) == 110){ //n
                                    flag = false;
                                } 
                            }
                        }  
                    }
                } 
                

            }while(flag);

            //contesta
            os.writeUTF("rebut");
            

            System.out.println("desconectando cliente");

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
