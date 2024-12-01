package aoc;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class D23 {

    public String simulate(String input, int mv) {
        List a = new LinkedList();
        char[] cups = input.toCharArray();
        char[] tmp = new char[input.length()];

                int cur = 0;
                for(int i=0; i<mv; i ++) {
                    char[] removed = Arrays.copyOfRange(cups, cur + 1, cur + 4);
                    tmp[cur] = cups[cur];
                    char selected = cups[cur];
                }

        return cups.toString();
    }

}
