package challenges;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    
    public static void main(String[] args) {
        int[] numbers = {10, 0, 10, 10, 50};
        int target = 20;
        System.out.println(twoSum(numbers, target)[0]);
        System.out.println(twoSum(numbers, target)[1]);

    }
    /**
     * Encontra a soma dos dois primeiros elementos do array int[] numbers que resulta em int 'target'
     * @param numbers int[ ]
     * @param target int
     * @return int[ ]
     */
    public static int[] twoSum(int[] numbers, int target) {
        
        //Gerando um ArrayList (List) a partir de um array convencional:
        List<Integer> lNumbers = listOfArray(numbers);
        
        List<Integer> lNumbersCopy = new ArrayList<Integer>(lNumbers);

        int[] result = new int[]{-1,-1};

        //variável auxiliar que faz o track dos elementos:
        int aux;

        do {
            aux = lNumbers.remove(0);
            for (Integer integer : lNumbers) {
                if (aux + integer.intValue() == target){
                    result[0] = lNumbersCopy.indexOf(Integer.valueOf(aux));
                    if (aux == integer.intValue()) {
                        result[1] = lNumbers.indexOf(integer)+1;
                    }
                    else {
                        result[1] = lNumbersCopy.indexOf(integer);
                    }
                    
                    return result;
                }
            }   
        } 
        while (lNumbers.size() > 1);

        return result;
    }

    private static List<Integer> listOfArray(int[] numbers) {
        //É preciso usar o recurso da Stream API: 
        List<Integer> lNumbers = new ArrayList<Integer>(Arrays.stream(numbers).boxed().toList());
        return lNumbers;
    }
}
