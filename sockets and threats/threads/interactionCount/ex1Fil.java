public class ex1Fil  {

    public static void main(String[] args) {
        // ejecutar els fils
        filEx1 th1 = new filEx1("1");
        filEx1 th2 = new filEx1("2");
        filEx1 th3 = new filEx1("3");

        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        Thread t3 = new Thread(th3);

        t1.start();
        t2.start();
        t3.start();
    }

}