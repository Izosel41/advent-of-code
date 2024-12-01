package aoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D01 {

    public int one(List<String> lines) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int spread =0;

        for (String line : lines) {
            left.add(Integer.parseInt(line.split("\\s+")[0]));
            right.add(Integer.parseInt(line.split("\\s+")[1]));
        }

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        for (int i = 0; i <left.size(); i++) {
            spread += Math.abs(left.get(i) - right.get(i));
        }

        return spread;
    }


    public long two(List<String> lines) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        long spread =0;

        for (String line : lines) {
            left.add(Integer.parseInt(line.split("\\s+")[0]));
            right.add(Integer.parseInt(line.split("\\s+")[1]));
        }

        for (int i = 0; i <left.size(); i++) {
            int finalI = i;
            spread += left.get(i) * right.stream().filter(integer -> Objects.equals(integer, left.get(finalI))).count();
        }

        return spread;
    }

}
