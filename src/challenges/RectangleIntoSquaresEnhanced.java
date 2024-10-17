package challenges;

import java.util.ArrayList;
import java.util.List;

public class RectangleIntoSquaresEnhanced {

    public static void main(String[] args) {
        System.out.println(sqInRect(10, 4));

    }

    public static List<Integer> sqInRect(int lng, int  wdth) {

        //Requisito de projeto: se a área inicial é um quadrado, o resultado será null;
        if (lng == wdth) {
            return null;
        }

        /*  
         *  Todo retângulo tem dentro dele, pelo menos, um quadrado:
         *  Extraindo a área quadrada:
        */
        int areaQuadrado = 0;

        // Lista que irá "segurar" o resultado final:
        List<Integer> result = new ArrayList<Integer>();

        //Enquanto nenhuma das dimensões é igual a 1, o loop abaixo funciona:
        while(!(lng==1 || wdth==1)) {

            if(lng > wdth) {
                areaQuadrado = (int) Math.pow(wdth, 2);
                lng = lng - wdth;
            } 
            else if (wdth > lng) {
                areaQuadrado = (int) Math.pow(lng, 2);
                wdth = wdth - lng;
            }
            else if (wdth == lng) {
                result.add(wdth);
                break;
            }

            if (areaQuadrado != 0) {
                result.add((int) Math.sqrt(areaQuadrado));
            }
        
        }

        if(lng == 1) {
            for (int i = 0; i < wdth ; i++) {
                result.add(1);
            }
        }
        else if (wdth == 1) {
            for (int i = 0; i < lng ; i++) {
                result.add(1);
            }
        }

        return result;
	}

}