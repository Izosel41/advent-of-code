import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class D09 {

    private Set<String> pos;

    public int one(List<String> puzzle) {
        pos = new HashSet<>();
        Knob head = new Knob(0, 0);
        Knob tail = new Knob(0, 0);

        List<Knob> rope = new ArrayList<>();
        rope.add(head);
        rope.add(tail);

        for (String cmd : puzzle) {
            String[] cmds = cmd.split(" ");
            int repeat = Integer.parseInt(cmds[1]);
            for (int i = 0; i < repeat; i++) {
                pullHead(cmds[0], head);
                pull(head, tail, true);
            }
        }
       // debugPos();
        // +1 for 0;0
        return pos.size() + 1;
    }

    private Knob pull(Knob first, Knob next, boolean isTrail) {

        int xHead = first.x;
        int yHead = first.y;

        int xTail = next.x;
        int yTail = next.y;
        int difX = xHead - xTail;
        int difY = yHead - yTail;

        // H . .
        // . . .
        // . T .
        if (difX == -1 && difY == -2) {
            xTail--;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . H .
        // . . .
        // . T .
        if (difX == 0 && difY == -2) {
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . . H
        // . . .
        // . T .

        if (difX == 1 && difY == -2) {
            xTail++;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }


        // T . .
        // . . .
        // . H .
        if (difX == 1 && difY == 2) {
            xTail++;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . T .
        // . . .
        // . H .
        if (difX == 0 && difY == 2) {
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . . T
        // . . .
        // . H .
        if (difX == -1 && difY == 2) {
            xTail--;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . . .
        // . . T
        // H . .
        if (difX == -2 && difY == 1) {
            xTail--;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . . .
        // H . T
        // . . .
        if (difX == -2 && difY == 0) {
            xTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // H . .
        // . . T
        // . . .
        if (difX == -2 && difY == -1) {
            xTail--;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }


        // . . .
        // . . H
        // T . .
        if (difX == 2 && difY == -1) {
            xTail++;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // . . .
        // T . H
        // . . .
        if (difX == 2 && difY == 0) {
            xTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        // T . .
        // . . H
        // . . .
        if (difX == 2 && difY == 1) {
            xTail++;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        if (difX == 2 && difY == 2) {
            xTail++;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }
        if (difX == -2 && difY == 2) {
            xTail--;
            yTail++;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }
        if (difX == -2 && difY == -2) {
            xTail--;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }
        if (difX == 2 && difY == -2) {
            xTail++;
            yTail--;
            if (isTrail)
                pos.add(xTail + ";" + yTail);
        }

        next.x = xTail;
        next.y = yTail;

        return next;
    }

    public int two(List<String> puzzle) {
        pos = new HashSet<>();

        List<Knob> rope = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rope.add(new Knob(0, 0));
        }

        for (String cmd : puzzle) {
            System.out.println("**** " + cmd);
            String[] cmds = cmd.split(" ");
            int repeat = Integer.parseInt(cmds[1]);
            for (int i = 0; i < repeat; i++) {
                rope.set(0, pullHead(cmds[0], rope.get(0)));
                for (int j = 0; j < rope.size() - 2; j++) {
                    Knob tmp = pull(rope.get(j), rope.get(j + 1), false);
                    rope.set(j + 1, tmp);
                }
                Knob tmp = pull(rope.get(rope.size() - 2), rope.get(rope.size() - 1), true);
                rope.set(rope.size() - 1, tmp);
            }

        }
        //debugPos();

        // +1 for 0;0
        return pos.size() + 1;
    }

    private void debugPos() {

        System.out.println("");
        for (int x = -15; x < 15; x++) {
            for (int y = -15; y < 15; y++) {
                if (pos.contains(y + ";" + x)) {
                    System.out.print("#");
                } else {
                    if (x == 0 && y == 0)
                        System.out.print("s");
                    else
                        System.out.print(".");

                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private Knob pullHead(String cmd, Knob head) {
        int xHead = head.x;
        int yHead = head.y;

        switch (cmd) {
            case "U":
                yHead--;
                break;
            case "D":
                yHead++;
                break;
            case "L":
                xHead--;
                break;
            case "R":
                xHead++;
                break;
        }
        head.x = xHead;
        head.y = yHead;
        return head;
    }
}
class Knob {
    int x;
    int y;

    @Override
    public String toString() {
        return "Knob{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Knob(int x, int y) {
        this.x = x;
        this.y = y;

    }
}

