import java.io.UnsupportedEncodingException;

public class proba {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String x = "hola quie tal?";

        byte[] z = x.getBytes("ASCII");

        for(int i  = 0; z.length > i ; i++){
            System.out.print(z[i]+" - ");
        }

    }
}