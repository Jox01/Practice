

public class main1_JaumeBorras {

    public static void main(String[] args) {

        FilNumeroLetras h1 = new FilNumeroLetras(1);
        FilNumeroLetras h2 = new FilNumeroLetras(2);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
        
    }

}
