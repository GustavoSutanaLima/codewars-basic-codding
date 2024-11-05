package challenges;

import java.util.Arrays;
import java.util.stream.Stream;

public class Rot13 {

    public static void main(String[] args) {
        System.out.println(rot13("5xQ^KO_4$lXb_"));
        System.out.println(rot13("_"));

    }

    public static String rot13(String message) {

        String[] splitedMessage = message.split(" ");
        
        StringBuilder stringBuilder = new StringBuilder();

        Stream<String> rotatedString = Arrays.asList(splitedMessage)
                                            .stream()
                                            .map(string -> auxRot(string));

        rotatedString.forEach(string -> stringBuilder.append(string).append(" "));

        return stringBuilder.toString().substring(0, stringBuilder.length()-1);

    }

    private static String auxRot(String message) {
        //criando uma String para ciclar os chars
        String vocab = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

        //Como meu vocab tem o dobre de elementos, vou rotacionar 13 vezes 2;
        int rot26 = 26;

        //tamanho do vocab
        int vocabSize = vocab.length();

        //Indexing the vocab;
        int vocabIndex = 0;

        //Stringbuild para poder criar uma nota string rotacionada;
        StringBuilder resultString = new StringBuilder();

        //identificando a posição dos elementos do argumento de rot13;
        for (Character character : message.toCharArray()) {
            //adiciona as posições das letras ao ArrayList Positions:
            vocabIndex = vocab.indexOf(character.toString());

            if(vocabIndex == -1) {
                resultString.append(character.toString());
            }
            else {
                if(vocabIndex+rot26>=vocabSize) {
                    vocabIndex = vocabIndex+rot26-vocabSize;
                }
                else {
                    vocabIndex = vocabIndex+rot26;
                }
                resultString.append(vocab.charAt(vocabIndex));
            }

        }
        
        return resultString.toString();
    }
}
