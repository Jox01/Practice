public class FilUsuari extends Thread {

    private int accio;

    public FilUsuari(Runnable runnable, int accio) {
        super(runnable);
        this.accio = accio;
    }

    public int getAccio() {
        return accio;
    }
    
}
