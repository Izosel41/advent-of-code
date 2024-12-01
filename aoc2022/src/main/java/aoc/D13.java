package aoc;

import org.json.JSONArray;

import java.util.List;

class D13 {

    public int one(List<String> puzzle) {
        int res = 0;
        for (int line = 0; line <= puzzle.size(); line = line + 3) {

            JSONArray left = new JSONArray(puzzle.get(line));
            JSONArray right = new JSONArray(puzzle.get(line + 1));
            int rightOrder = isRightOrder(left, right, false, false);

            System.out.println("== Pair " + (line / 3 + 1) + " == " + rightOrder);
            res = res + (rightOrder == 1 ? (line / 3 + 1) : 0);
        }

        return res;
    }

    int isRightOrder(JSONArray left, JSONArray right, boolean isLeftMixed, boolean isRightMixed) {
        System.out.println(left + ":" + right);

        int i = 0;
        int res = 0;

        while (res == 0 && i < left.length() && i < right.length()) {
            // Left side shall be less
            if (left.get(i) instanceof Integer l && right.get(i) instanceof Integer r)
                res = Integer.compareUnsigned(r, l);
            else if (left.get(i) instanceof Integer l && right.get(i) instanceof JSONArray r)
                res = isRightOrder(new JSONArray().put(l), r, true, false);
            else if (left.get(i) instanceof JSONArray l && right.get(i) instanceof Integer r)
                res = isRightOrder(l, new JSONArray().put(r), false, true);
            else if (left.get(i) instanceof JSONArray l && right.get(i) instanceof JSONArray r)
                res = isRightOrder(l, r, false, false);
            i++;
        }

        if (res == 0) {
            if (right.length() < left.length())
                return -1;
            else if (right.length() == left.length())
                return 0;
            else return 1;
        } else return res;
    }


    public int two(List<String> puzzle) {
        //divider packets
        puzzle.add("[[2]]");
        puzzle.add("[[6]]");
        List<String> list = puzzle
                .stream()
                .filter(s -> !s.isEmpty())
                .map(JSONArray::new)
                //aware of o2 then o1
                .sorted((o1, o2) ->  isRightOrder(o2, o1, false, false))
                //JSONArray does not provide compare method
                .map(JSONArray::toString)
                .toList();


        return (list.indexOf("[[2]]")+1) * (list.indexOf("[[6]]")+1);

    }
}
