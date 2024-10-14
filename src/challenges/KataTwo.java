package challenges;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.LongStream;


public class KataTwo{

    public static void main(String[] args) {
        long[] arrayOne = {15, 28, 4, 4, 43};
        System.out.println("Sum = " + sumTwoSmallestNumbers(arrayOne));
    }   


    public static long sumTwoSmallestNumbers(long[] numbers) {
        //converte o array de longs para um LongStream
        LongStream nuList = Arrays.stream(numbers);
        
        /* .sorted() organiza os elementos do LongStream em ordem crescente
         * .bonext() converte o LongStream para Stream<Long>;
         * .limit() pega uma porção dessa stream, neste caso .limit(2), pega os dois primeiros elementos da Stream;
         * .reduce((n, o) -> (n+=o)) soma os elementos Long da stream e retorna um Optional<Long>
         */
        Optional<Long> nuListSorted = nuList.sorted().boxed().limit(2).reduce((n, o) -> (n+=o));

        //.get() retorna o valor do optional se não for null;
        return nuListSorted.get();
    }

}