
public class FilNumeroLetras implements Runnable {
    public static Object object1 = new Object();
    private int tipus; 

    public FilNumeroLetras(int tipus) {
        this.tipus = tipus;

    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    
    @Override
    public void run() {

        synchronized (object1){
            
            if(this.getTipus() == 1){
                //nums
                for (int i = 1; i <= 30; i++) {
                    System.out.println(i);
                }
            }else{
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.println(i);
                }
            }
        }
    }
    
}