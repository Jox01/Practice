package aleatoris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class JaumeBorrasaleatorisMain {

    public static void main(String[] args) throws IOException {
        try {
        // create a new process
        String line;
        Boolean aux = true;
        Scanner s = new Scanner(System.in);

        System.out.println("Creating Process..."); //cream proces
        Process pc = new ProcessBuilder("Serveis i procesos\\aleatoris\\aleatorisC.exe").start();
        System.out.println("Proces Creado");

        BufferedReader br = new BufferedReader(new InputStreamReader(pc.getInputStream())); //no posam pc en ningun lloc peruqe esta dins el BufferReader
        System.out.println("BufferReader Creado"); //cream bufferReader

        PrintStream ps = new PrintStream(pc.getOutputStream()); 
        System.out.println("PrintStream");
        
        ps.println(); //executar per primera vegada el proces per conseguir el primer num
        ps.flush(); 
        line = br.readLine();
        System.out.println(line);

        do{ 

            if(line.equals("4")){  //si es 4 cambia el boolean per sortir del bucle i tanca el proces

                aux = false;
                pc.destroy();
                ps.close();

            }else{              //en cas de no ser 4 es segueix executant el fill

                ps.println(); //No es necesario escribir nada
                ps.flush(); // Asegura que los datos se han enviado
                line = br.readLine();
                System.out.println(line);
                
            }
            
        }while(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            s.close();
        }

    }

}
