package strings.challenges;

import java.util.*;

public class Persist {
   
	public static int persistence(long n) {

        if (String.valueOf(n).length() == 1) {
            return 0;
        }
        else {
            int auxContagem = 1;
            while (String.valueOf(digitsMultiplier(n)).length() > 1) {
    
                n = digitsMultiplier(n);
                auxContagem++;
            }
    
            return auxContagem;
        }
        
    
	}

    static int digitsMultiplier(long n) {
        String nString = Long.toString(n);
	
        var stringStream = Arrays.stream(nString.split(""));

        long result = 1;

        for (long i : stringStream.mapToInt(Integer::parseInt).toArray()) {
            result*=i;
        }
    
        return (int) result;
        
    }
}
 