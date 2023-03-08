

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class JaumeBorrasMinusToMayusMain {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        try {
            // create a new process
            String line;
        
            
            System.out.println("Creating Process..."); //cream proces
            Process pc = new ProcessBuilder("Serveis i procesos\\minusToMayus\\a.exe").start();
            System.out.println("Proces Creado");

            BufferedReader br = new BufferedReader(new InputStreamReader(pc.getInputStream())); //no posam pc en ningun lloc peruqe esta dins el BufferReader
            System.out.println("BufferReader Creado"); //cream bufferReader

            PrintStream ps = new PrintStream(pc.getOutputStream()); 
            System.out.println("PrintStream");
            System.out.println("Introdueix Minuscules");
        
            ps.println(s.nextLine()); //executar per primera vegada el proces per conseguir el primer num
            ps.flush(); 
            line = br.readLine();
            System.out.println(line);
            
        } catch (IOException r) {
            
            System.out.println(r.getMessage());
        }finally{
            s.close();
        }

        

    }

}
