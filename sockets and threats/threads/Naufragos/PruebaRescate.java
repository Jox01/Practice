/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naufragos;


/**
 *
 * @author adria
 */
public class PruebaRescate implements Runnable {

    private Naufrago nf = new Naufrago((int) (Math.random() * (1000 - 800) + 800));

    public static void main(String[] args) {
        PruebaRescate pruebaRescateRunnable = new PruebaRescate();

        Balsa balsa1 = new Balsa(pruebaRescateRunnable, (int) (Math.random() * (40 - 20) + 20));
        Balsa balsa2 = new Balsa(pruebaRescateRunnable, (int) (Math.random() * (50 - 30) + 30));
        Balsa balsa3 = new Balsa(pruebaRescateRunnable, (int) (Math.random() * (60 - 40) + 40));

        balsa1.setName("Balsa 1");
        balsa2.setName("Balsa 2");
        balsa3.setName("Balsa 3");

        balsa1.start();
        balsa2.start();
        balsa3.start();
        
    }

    /*
 * este método sólo se ejecuta mientras queden náufragos, llama al siguiente método
 * y además almacena la cantidad de plazas para cada balsa.
     */
    @Override
    public void run() {
        while(nf.getCantidadNaufragos() >= 0){

            //valor de la cantidad a una variable
            int cantidadPlazas = ((Balsa)Thread.currentThread()).getNumPlazas(); 

            //pasa al metodo synchronized
            rescatar(cantidadPlazas);
        }
    }

    /*
 * método sincronizado para evitar problemas de concurrencia si las 3 balsas
 * intentan rescatar a la vez a los náufragos, con esto sólo permitimos el pasado
 * a una de ellas para que el número de náufragos restante se actualice correctamente.
     */
    private synchronized void rescatar(int cantidadPlazas) {
       
        if(nf.getCantidadNaufragos()>=0){

            //informa caantidad de neufragis
            System.out.println("Quedan "+nf.getCantidadNaufragos()+" naufragos");

            //nombre de la balsa
            System.out.println("Se esta rescatando: " + Thread.currentThread().getName()+ 
            " con "+cantidadPlazas);

            //resta en el objeto
            nf.rescatesRestantes(cantidadPlazas);
            
            //espera a los otros hilos
            try{
                Thread.sleep(1000);
            }catch(Exception e) {
                e.printStackTrace();
            }


            //primer intent de fer en flags
            /*switch(Thread.currentThread().getName()){
                case "Balsa 1":

                    nf.rescatesRestantes(cantidadPlazas);
                    nf.getCantidadNaufragos();
                    try{
                        Thread.sleep(500);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "Balsa 2":

                    nf.rescatesRestantes(cantidadPlazas);

                    try{
                        Thread.sleep(500);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                    break;

                case "Balsa 3":

                    nf.rescatesRestantes(cantidadPlazas);

                    try{
                        Thread.sleep(500);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    
                    break;
            }*/

        }else{
            System.out.println("Ya no hay que rescatar mas personas");
            System.out.println(Thread.currentThread().getName() + " vuelve a su sitio");
        }

    }

}
