package challenges;


import java.util.Arrays;
import java.util.List;

public class SpinWords {

    public static void main(String[] args) {
       String inputString = "This is an awesome test";

       String test =  SpinWords.spinWords(inputString);

       System.out.println("Original: " + inputString);
       System.out.println("Reversed: " + test);
    }


    public static String spinWords(String sentence) {
        
        List<String> sliptedSetence = Arrays.asList(sentence.split(" "));

        StringBuilder mutableStringAux = new StringBuilder();

        for (String string : sliptedSetence) {
            if(string.length() >= 5) {
                mutableStringAux.append(reverser(string) + " ");
            }
            else {
                mutableStringAux.append(string  + " ");
            }
            
        }
    
        return mutableStringAux.toString().substring(0,sentence.length());
    }

    private static String reverser(String stringToReverse) {

        StringBuilder reversed = new StringBuilder(stringToReverse);
        
        return reversed.reverse().toString();
    }
  }