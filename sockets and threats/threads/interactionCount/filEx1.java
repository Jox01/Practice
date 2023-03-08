public class filEx1 implements Runnable {

    private String name;

    filEx1(String name){
        this.name = name;
    }

    @Override
    public void run() {

        // indica quin fil es tracte i quina iteniracio es
            
        System.out.println("Inicia Thread: "+this.getName());

        for (int i = 0; 10 >= i; i++) {

            System.out.println("iteracion num: "+i+" en el thread: " + this.getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }       

        System.out.println("Finalza thread: " + this.getName());
        
    }

    public String getName() {
        return name;
    }
    
}
