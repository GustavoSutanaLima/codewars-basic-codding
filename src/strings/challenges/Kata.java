package strings.challenges;

public class Kata {
    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 3 4 5"));
        System.out.println(highAndLow("1 2 -3 4 5"));
        System.out.println(highAndLow("1 9 3 4 -5"));
    }
    /**
     * Aceita uma lista de números em forma de String, separados por espaços.
     * @param numbers
     * @return
     */
    public static String highAndLow(String numbers) {
        //separa os elementos da string de acordo com um separador, neste caso, espaço: " ";
        //esse método gera uma array em java, e esse array é atribuido à vairável numbersList;
        String[] numbersList = numbers.split(" ");

        //Converterndo os elementos do array de string para int:

        //cria um array de inteiros com o o mesmo tamanho do array de strings:
        int[] numbersListAsInt = new int[numbersList.length];

        //variável auxiliar de iterção do loop abaixo:
        int auxLoopOne = 0;
        //coverter os elementos do array strings para int e atribui ao array de ints;
        for (String string : numbersList) {
            numbersListAsInt[auxLoopOne] = Integer.parseInt(string);
            auxLoopOne++;
        }

        //variável auxliar para armazenar o maior valor:
        int maiorValor = Integer.MIN_VALUE;
        //variável auxiliar para armazenar o menor valor:
        int menorValor = Integer.MAX_VALUE;

        //confere se o valor valor da lista é maior que o menor valor possível de um int em java, 
        //se ele for atribui esse valor à variável maiorValor e assim por diante;
        for (int i : numbersListAsInt) {
            if (i > maiorValor){
                maiorValor = i;
            }
        }
        //idem ao for anterior, porém, para o menor valor;
        for (int i: numbersListAsInt) {
            if (i < menorValor){
                menorValor = i;
            }
        }

        return maiorValor + " " + menorValor;
    }
}
