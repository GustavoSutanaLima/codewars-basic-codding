package strings.challenges;

public class StringEndsWith {
    private String stringOne;
    private String stringDois;

    public static boolean solution(String stringOne, String stringTwo) {
        boolean result = false;
        try {
            //Armazena o tamanho da stringTwo na variável tamanhoStringDois:
            int tamanhoStringDois = stringTwo.length();

            //Manipulando a stringUm:
            String stringOneAux = stringOne.substring(stringOne.length()-tamanhoStringDois, stringOne.length());

            result = stringOneAux.equals(stringTwo);

        } catch (Exception e) {
            System.out.println("Não é possível comparar essas strings: tamanhos diferentes!");
        }

        return result;
        
    }
}
