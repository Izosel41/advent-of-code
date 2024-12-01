package aoc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class D03 {

    public int rucksack(List<String> puzzle) {
        return puzzle.stream()
                .mapToInt(D03::findIntersec)
                .sum();
    }

    private static int findIntersec(String e) {

        Set<String> left = new HashSet<>(Arrays.asList(e.substring(0, e.length() / 2).split("")));
        Set<String> right = new HashSet<>(Arrays.asList(e.substring(e.length() / 2).split("")));

        left.retainAll(right);
        char c = ((String) left.toArray()[0]).charAt(0);
        if (c < 91)
            return c - 38;
        else
            return c - 96;
    }

    public int byThree(List<String> puzzle) {
        String[] p = puzzle.toArray(new String[0]);
        int res = 0;
        for(int i=0; i< puzzle.size(); i=i+3){
            res = res +findCommon(p[i], p[i+1], p[i+2]);
        }
        return res;
    }

    private int findCommon(String s, String s1, String s2) {

        Set<String> left = new HashSet<>(Arrays.asList(s.split("")));
        Set<String> middle = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> right = new HashSet<>(Arrays.asList(s2.split("")));

        left.retainAll(middle);
        left.retainAll(right);
        char c = ((String) left.toArray()[0]).charAt(0);
        if (c < 91)
            return c - 38;
        else
            return c - 96;
    }
}
