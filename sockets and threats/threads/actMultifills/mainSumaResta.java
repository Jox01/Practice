
public class mainSumaResta implements Runnable {

    static private int num = 0;

    public static void main(String[] args) {

        mainSumaResta mSM = new mainSumaResta();

        FilSumaResta f1 = new FilSumaResta(mSM);
        FilSumaResta f2 = new FilSumaResta(mSM);

        f1.setName("1");
        f2.setName("2");
        
        f1.start();
        f2.start();
    }

    @Override
    public void run(){

        if(Thread.currentThread().getName().equals("1")){
            num++;
            System.out.println(num);
        }else{
            num--;
            System.out.println(num);
        }

        operar();
    }

    private synchronized void operar(){

        if(Thread.currentThread().getName().equals("1")){

            for(int i = 0 ; i <= 9 ; i++){
                num++;
                System.out.println(num);
            }
            
        }else{

            for(int i = 0 ; i <= 9 ; i++){
                num--;
                System.out.println(num);
            }

        }
    }
}
