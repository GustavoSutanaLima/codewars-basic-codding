package challenges;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    public int solution(int number) {
        
        var result = decreaser(number)
            .stream()
            .filter(element -> element % 3 == 0 || element % 5 == 0)
            .reduce((n1, n2)->(n1+=n2));

        return result.get().intValue();
    }

    private List<Integer> decreaser(int number) {
        List<Integer> listOfNumber = new ArrayList<Integer>();
        
        while(number > 1) {
            number--;
            listOfNumber.add(number);
        }
        
        return listOfNumber;
    }

}