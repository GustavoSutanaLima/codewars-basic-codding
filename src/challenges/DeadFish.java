package challenges;

import java.util.ArrayList;
import java.util.List;

public class DeadFish {

    public static void main(String[] args) {
        System.out.println(DeadFish.parse("iiisdoso"));
    }
    
    public static int[] parse(String data) {

        List<Integer> listResult = new ArrayList<Integer>();

        int valueToInsert = 0;

        for (Character character : data.toLowerCase().toCharArray()) {
            switch (character.charValue()) {
                case 'i': {
                    valueToInsert++;
                    break;
                }
                case 'd': {
                    valueToInsert--;
                    break;
                }
                case 's':{
                    valueToInsert = (int) Math.pow(valueToInsert, 2);
                    break;
                }
                case 'o':{
                    listResult.add(valueToInsert);
                    break;
                }
            }
        }
        
        int[] arrayResult = listResult.stream().mapToInt(Integer::intValue).toArray();

        return arrayResult;
    }
}
