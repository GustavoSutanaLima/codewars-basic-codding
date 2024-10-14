package challenges;

import java.lang.StringBuilder;
import java.util.MissingFormatArgumentException;

public class SolutionTwo{ 
 /*
    * A classe String cria um objeto String que é imutável, ou seja, não é possível alterar o conteúdo de uma 
    * String depois que ela é criada. Porém, é possível atribuir um novo objeto deste tipo à variável.
    * 
    * Já o StringBuffer permite a mutação do conteúdo de uma string, ou seja, é uma string mutável. 
    * Ele é usado quando há a necessidade de realizar várias modificações em uma string.

    * A principal diferença entre StringBuilder e StringBuffer está relacionada à thread safety.

    * StringBuffer é sincronizado, o que significa que é seguro para uso por múltiplas threads ao mesmo tempo. 
    * Ele adiciona um overhead de performance por causa dessa sincronização, então pode ser mais lento em 
    * cenários de thread única.

    * StringBuilder não é sincronizado, o que significa que não é seguro para uso por múltiplas threads 
    * simultaneamente. No entanto, essa falta de sincronização faz com que ele seja mais rápido do que 
    * StringBuffer em operações de thread única.

    Em resumo, se você está trabalhando em um ambiente de thread única e precisa de uma string mutável, 
    StringBuilder é a melhor escolha devido à sua melhor performance. Se você precisa de thread safety, 
    então use StringBuffer.
 */

  public static String toCamelCase(String s) {

    //Lança uma exceção caso o formato seja inválido, ou seja, não contem nem "-" ou "_":
    if(!(s.contains("-") || s.contains("_"))) {
        throw new MissingFormatArgumentException("Invalid format! The String must contain '-' or '_'."); 
    }

    //cria uma string mutável a partir da String do argumento do método:
    StringBuilder sMutable = new StringBuilder(s);

    //variável auxiliar para indicar posição do traço ou underline ('-' o '_'):
    int index = 0;

    do {
        //Se não encontrar "-" ou "_" sai do loop;
        if (sMutable.indexOf("-") == -1 && sMutable.indexOf("_") == -1){
            break;
        }
        //se o index for diferente de -1, ou seja, não encontrou "-" na string, faz uma nova busca por, mas agora
        //por "_";
        else if (sMutable.indexOf("-") != -1) {
            index = sMutable.indexOf("-");
        }
        //busca por "_"
        else if (sMutable.indexOf("_") != -1) {
            index = sMutable.indexOf("_");
        }

        //deleta o char na posição que um dos caracteres "-" ou "_" foi encontrado;
        sMutable.deleteCharAt(index);

        //após o delete acima, o index passa a ser o da letra que deverá ser Upper Case, 
        //logo após, eu vou set um char nessa posição, por esse mesmo char, mas agora upercase
        sMutable.setCharAt(index, ((Character) sMutable.charAt(index)).toString().toUpperCase().charAt(0));
        
    } while(index != -1);
   
    return sMutable.toString();

  }
}