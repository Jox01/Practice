package Sum;

import java.util.*;

public class Sum {

    public Sum() {
    }

    public int GetSum(int a, int b)
    {
        int sum = 0; 

        if(a != b){
            
            //factorial sum
            for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {

                sum +=i;
                
            }
        }else{
            sum = a;
        }
        
        return sum;
    }
    
}
