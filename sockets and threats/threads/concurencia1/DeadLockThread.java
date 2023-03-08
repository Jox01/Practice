package concurencia1;

public class DeadLockThread {

    public static Object object1 = new Object();
    public static Object object2 = new Object();
    
    public static void main(String args[]) {
       Thread1 thread1 = new Thread1();
       Thread2 thread2 = new Thread2();
       thread1.start();
       thread2.start();
    }
    
    private static class Thread1 extends Thread {
       public void run() {
          synchronized (object1) {
             System.out.println("Thread 1: Holds object 1.");
             
             try { 
                Thread.sleep(10); 
             } catch (Exception e) {}
             System.out.println("Thread 1: Waiting for object 2.");
             
             synchronized (object2) {
                System.out.println("Thread 1: Holds object 1 and object 2.");
             }
          }
       }
    }
 
    private static class Thread2 extends Thread {
       public void run() {
          synchronized (object1) {
             System.out.println("Thread 2: Holds object 2.");
             
             try { 
                Thread.sleep(10); 
             } catch (Exception e) {}
             System.out.println("Thread 2: Waiting for object 1.");
             
             synchronized (object2) {
                System.out.println("Thread 2: Holds object 1 and object 2.");
             }
          }
       }
    } 
 }
