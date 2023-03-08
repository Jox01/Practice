
class HelloThread implements Runnable {

    Thread t;

    HelloThread(){
        t = new Thread(this, "Nou Thread");
        System.out.println("Creat fill: "+t);
        t.start();//arranca
    }

    public void run(){
        System.out.println("Hola desde el fill creat");
        System.out.println("Fill finalitzar");
    }

    static class RunThread {
        public static void main(String[] args) {
            new HelloThread();
            System.out.println("Hola desde el fill principal");
            System.out.println("Proces acabat");
        }
    }

}