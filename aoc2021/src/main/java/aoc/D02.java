package aoc;

import java.util.Iterator;
import java.util.List;

class D02 {

    public int[] pilot(List<String> insts) {
        // pos [x, depth]
        int[] pos = new int[]{0, 0};

        Iterator<String> ite = insts.iterator();
        while (ite.hasNext()) {
            String inst[] = ite.next().split(" ");

            switch (inst[0]) {
                case "forward":
                    pos[0] = pos[0] + Integer.parseInt(inst[1]);
                    break;
                case "down":
                    pos[1] = pos[1] + Integer.parseInt(inst[1]);
                    break;
                case "up":
                    pos[1] = pos[1] - Integer.parseInt(inst[1]);
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return pos;
    }

    public int[] pilotAim(List<String> insts) {
        // pos [x, depth, aim]
        int[] pos = new int[]{0, 0, 0};
 //       System.out.println("pos depth aim");
        Iterator<String> ite = insts.iterator();
        while (ite.hasNext()) {
            String inst[] = ite.next().split(" ");

            switch (inst[0]) {
                case "forward":
                    pos[0] = pos[0] + Integer.parseInt(inst[1]);
                    pos[1] = pos[1] + pos[2] * Integer.parseInt(inst[1]);
                    break;
                case "down":
                    pos[2] = pos[2] + Integer.parseInt(inst[1]);
                    break;
                case "up":
                    pos[2] = pos[2] - Integer.parseInt(inst[1]);
                    break;
                default:
                    throw new RuntimeException();
            }
 //           System.out.println(pos[0] + " " + pos[1] + " " + pos[2]);
        }
        return pos;
    }
}
