package challenges;


public class BreakCamelCase {

    public static void main(String[] args) {
        String string = "";
        
        System.out.println(string);
        System.out.println(camelCase(string));
    }

    public static String camelCase(String input) { 

        StringBuilder inputMutable = new StringBuilder(input);

        char[] inputAsChars = input.toCharArray();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇ"; 

        int indexAux = 0;

        for (int index = 0; index < inputAsChars.length; index++) {
            for (char charUpper : upper.toCharArray()) {
                if(charUpper == inputAsChars[index]) {
                    inputMutable.replace(index+indexAux, index+indexAux, " ");
                    indexAux++;
                }
            }
        }

        return inputMutable.toString();
    }
}  
