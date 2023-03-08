import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ex5B {

    static int countClients = 0;

    public static void main(String[] args) throws IOException {
        // socket server
        ServerSocket server;
        // socket del cliente
        Socket sc;
        final int port = 5000;
        DataOutputStream os;


        try {
            server = new ServerSocket(port);

            System.out.println("servidor iniciado");

            while(true){
                sc = server.accept();
                os = new DataOutputStream(sc.getOutputStream());
                countClients++;
                System.out.println("entrada de cliente num: "+countClients);
                
                //contesta
                os.writeUTF(String.valueOf(countClients));
                System.out.println("desconectando cliente");

                sc.close();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
