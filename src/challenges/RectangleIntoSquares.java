package challenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class RectangleIntoSquares {

    public static void main(String[] args) {
        System.out.println(sqInRect(5, 4));

    }

    public static List<Integer> sqInRect(int lng, int  wdth) {

        /*  Todo retângulo tem dentro dele um quadrado:
         *  Extraindo a área quadrada:
        */
        int areaQuadrado = 0;

        int[] dimensoesAreaRestante = {0, 0};

        if(lng > wdth) {
            areaQuadrado = (int) Math.pow(wdth, 2);
            dimensoesAreaRestante[0] = lng - wdth;
            dimensoesAreaRestante[1] = wdth;
        } 
        else if (wdth > lng) {
            areaQuadrado = (int) Math.pow(lng, 2);
            dimensoesAreaRestante[0] = wdth - lng;
            dimensoesAreaRestante[1] = lng;
        }
        else if (lng == wdth) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (areaQuadrado != 0) {
            result.add((int) Math.sqrt(areaQuadrado));
        }

       result.addAll(getListOfAreas(dimensoesAreaRestante[0]*dimensoesAreaRestante[1]));

        return result;
	}

    private static List<Integer> getListOfAreas(int area) {
        List<Integer> result = new ArrayList<Integer>();

        while(area>0) {
            final int areaAtual = area;

            //Este Stream<Integer> irá "segurar" os divisores da area:
            var dummyStream = IntStream .range(1, area) //gera uma IntStream, de 1 até o valor da área (exclusivo);
                                        .filter(n -> areaAtual % n == 0) //depois filtra a IntStram e filtra os divisores deste valor de área;
                                        .map(n -> n*n) //eleva cada um dos divisores ao quadrado;
                                        .boxed() //transforma a IntStream em uma Stream<Integer>;
                                        .sorted(Comparator.reverseOrder()) //Inverte a ordem da Stream<Integer>: [1, 9, 25] -> [25, 9, 1] 
                                        .toList(); //Converte a Stream<Integer> para uma List<Integer>;
                                    
            for (Integer integer : dummyStream) {
                if(area/integer < 1) {
                    continue;
                }
                else if (area/integer >= 1 && area % integer >= 0){
                    for (int i = 0; i < (int) area/integer; i++) {
                        result.add(integer);
                    }
                    area = area % integer;
                    break;
                }
            }
        
        }

		return result.stream().map(n -> Math.sqrt(n)).map(Double::intValue).toList();
    }
}
