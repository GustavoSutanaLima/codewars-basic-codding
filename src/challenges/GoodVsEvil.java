package challenges;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;

public class GoodVsEvil {

    public static void main(String[] args) {
        System.out.println(GoodVsEvil.battle("1 1 1 1 1 2", "1 1 1 1 1 1 1"));
    }

    public static String battle(String goodAmounts, String evilAmounts) {

        var resultForGoodSide = getResult(goodAmounts,"1 2 3 3 4 10");

        var resultForEvilSide = getResult(evilAmounts, "1 2 2 2 3 5 10");

        if (resultForGoodSide > resultForEvilSide) {
            return "Battle Result: Good triumphs over Evil";
        }
        else if (resultForGoodSide < resultForEvilSide) {
            return "Battle Result: Evil eradicates all trace of Good";
        }
        else {
            return "Battle Result: No victor on this battle field";
        }

    }

    private static int getResult(String sideAmounts, String worthAmounts) {
        List<Integer> side = stringToListOfIntegers(sideAmounts, " ");
        List<Integer> worth = stringToListOfIntegers(worthAmounts, " ");

        return IntStream.range(0, side.size()).map(index -> side.get(index)*worth.get(index)).sum();
    }

    private static List<Integer> stringToListOfIntegers(String stringToBeConverted, String regex) {

        // Verifica se a string contém números:
        if (stringToBeConverted.matches(".*\\d.*")) {
            return Arrays.stream(stringToBeConverted.split(regex)).mapToInt(Integer::parseInt).boxed().toList();
        }
        else {
            throw new IllegalArgumentException("A string não contém números.");
        }
    }
}
