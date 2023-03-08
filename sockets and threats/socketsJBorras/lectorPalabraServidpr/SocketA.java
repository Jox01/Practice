import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketA {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 5000;
        Socket sc;
        DataInputStream is;
        DataOutputStream os;
        String mensajeTotal = "";
        String confirma;
        String aux;
        Scanner scanner = new Scanner(System.in);

        try {

            sc = new Socket(host, port);

            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());

            System.out.println("cliente iniciado");

            System.out.println("OK para confirmar");

            confirma = scanner.nextLine();

            os.writeUTF(confirma);

            if(confirma.equals("OK")){
                int numWord = is.readInt();

                System.out.println("cantidad de palabras: "+numWord);

                for( int i = 1 ; numWord >= i ; i++){
                    aux = is.readUTF();
                    mensajeTotal += aux+"-";
                }
            }else{
                System.out.println("No es confirma");
            }

            sc.close();

            System.out.println("cliente cerrado");

            System.out.println("el mensaje es: " + mensajeTotal);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
