package strings.tests;

import strings.challenges.StringEndsWith;

public class StringEndsWithTest {
    public static void main(String[] args) throws Exception {
       
        boolean result =  StringEndsWith.solution("abc", "ccccc");

        System.out.println(result);
    }
}
