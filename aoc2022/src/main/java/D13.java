import java.util.ArrayList;
import java.util.List;

class D13 {


    public int one(List<String> puzzle) {
        int res = 0;
        for (int i = 0; i < puzzle.size(); i = i + 2) {
            res = res + (isRightOrder(puzzle.get(i), puzzle.get(i + 1)) ? i + 1 : 0);
        }

        return res;
    }

    private boolean isRightOrder(String s1, String s2) {
        int res = 0;

        List<Object> left = buildPacket(s1);
        List<Object> right = buildPacket(s2);

        for (int i = 0; i < right.size(); i++) {
            Object l = left.get(i);
            Integer intL = null;
            if (l instanceof Integer) {
                intL = (Integer) l;
            } else {
                List<Object> arrayL = (List<Object>) l;
            }

            Object r = right.get(i);
            Integer intR = null;
            if (r instanceof Integer) {
                intR = (Integer) r;
            } else {
                List<Object> arrayR = (List<Object>) r;
            }

            // Left side shall be less
            res = res + (intL > intR ? 1 : 0);
        }

        return res == 0;
    }

    private List<Object> buildPacket(String s) {
        System.out.println(s);

        List<Object> res = new ArrayList<>();
        if (s.length() != 0) {
            String[] c = s.split("");
            int open = 0;
            int close = 0;

            for (int i = 0; i < c.length; i++) {
                switch (c[i]) {
                    case "[":
                        open = i;
                        break;
                    case "]":
                        close = i;
                        if (i!=c.length-1)
                            res.add(buildPacket(s.substring(open, close + 1)));
                        break;
                    case ",":
                        break;
                    default:
                        if (open == 0)
                            res.add(Integer.valueOf(c[i]));

                }
            }
        }
        return res;
    }


    public int two(List<String> puzzle) {
        return -1;

    }
}
