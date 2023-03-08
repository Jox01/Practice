public class mainBanc implements Runnable{

    static int global = 1000;
    
    public static void main(String[] args) {

        mainBanc mB = new mainBanc();

        FilUsuari u1 = new FilUsuari(mB, 20);
        FilUsuari u2 = new FilUsuari(mB, 50);
        FilUsuari u3 = new FilUsuari(mB, 100);
        FilUsuari u4 = new FilUsuari(mB, -20);
        FilUsuari u5 = new FilUsuari(mB, -50);
        FilUsuari u6 = new FilUsuari(mB, -100);

        u1.setName("1");
        u2.setName("2");
        u3.setName("3");
        u4.setName("4");
        u5.setName("5");
        u6.setName("6");

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
        u6.start();
        
    }

    @Override
    public void run(){

      
            operar();
        
        
    }

    private synchronized void operar(){

        
        int operacio =  ((FilUsuari)Thread.currentThread()).getAccio();

        String nomU =Thread.currentThread().getName();

        System.out.println("Global te: "+global);

        System.out.println("El usuari " + nomU + " operara " + operacio);

        global += operacio;

        System.out.println("Resultat: "+ global + "\n ______________________________\n");

    }

}
