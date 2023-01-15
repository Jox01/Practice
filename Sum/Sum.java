package Sum;

import java.util.*;

public class Sum {

    public Sum() {
    }

    public int GetSum(int a, int b)
    {
        int sum = 0; 

        if(a != b){
            //create a list
            ArrayList<Integer> summands = new ArrayList<Integer>(Arrays.asList(a,b));
            //sort
            summands.sort(null);
            sum = summands.get(0);
            //factorial sum
            for (int i = summands.get(0)+1; i <= summands.get(1); i++) {

                sum +=i;
                
            }
        }else{
            sum = a;
        }
        
        return sum;
    }
    
}
