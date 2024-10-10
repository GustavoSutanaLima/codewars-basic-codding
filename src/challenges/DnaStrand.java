package challenges;

import java.lang.StringBuilder;

public class DnaStrand {
    public static void main(String[] args) {
        System.out.println(makeComplement("AATTCC"));
    }

    public static String makeComplement(String dna) {
        //TODO: A -> T & C -> G
        StringBuilder dnaCompl = new StringBuilder(dna.toUpperCase());
        Character character;
        for (int i = 0; i < dnaCompl.length(); i++) {
            character = dnaCompl.charAt(i);
            character = character.charValue();
            switch (character.charValue()) {
                case 'A':
                    dnaCompl.setCharAt(i, 'T');
                    break;
                case 'C':
                    dnaCompl.setCharAt(i, 'G');
                    break;
                case 'T':
                dnaCompl.setCharAt(i, 'A');
                    break;
                case 'G':
                    dnaCompl.setCharAt(i, 'C');
                    break;
            }
        }
        return dnaCompl.toString();
    }
  }