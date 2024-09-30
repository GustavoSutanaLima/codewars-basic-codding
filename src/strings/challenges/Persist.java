package strings.challenges;

import java.util.*;

class Persist {
    public static void main(String[] args) {
        System.out.println(persistence(123));
    }

	public static int persistence(long n) {
        
        return digitsMultiplier(n);
    
	}

    private static int digitsMultiplier(long n) {
        String nString = Long.toString(n);
	
        var stringStream = Arrays.stream(nString.split(""));

        int result = 1;

        for (int i : stringStream.mapToInt(Integer::parseInt).toArray()) {
            result*=i;
        }

        return result;
    }
}