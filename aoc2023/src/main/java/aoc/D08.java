package aoc;

import java.util.*;

import static aoc.Utils.lcm;

public class D08 {

    public int one(List<String> puzzleTest) {
        List<String> inst = Arrays.stream(puzzleTest.getFirst().split("")).toList();

        puzzleTest.removeFirst();
        puzzleTest.removeFirst();

        List<Node> nodes = puzzleTest.stream().map(this::buildNode).toList();
        Node start = nodes.stream().filter(node -> "AAA".equals(node.data())).findFirst().get();

        return findStep(start, inst, nodes);
    }

    private int findStep(Node start, List<String> inst, List<Node> nodes) {
        int i = 0;
        while (!start.data().equals("ZZZ")) {
            String next = null;
            if ("R".equals(inst.get(i % inst.size()))) {
                next = start.right();
            } else {
                next = start.left();
            }
            start = applyInst(next, nodes);
            i++;
        }
        return i;
    }

    private Node applyInst(String next, List<Node> nodes) {
        return nodes.stream().filter(node -> next.equals(node.data())).findFirst().get();
    }

    private Node buildNode(String s) {
        String[] split = s.split("=");
        String key = split[0].trim();
        String[] map = split[1].trim().split(",");

        return new Node(key, map[0].replace("(", "").trim(), map[1].replace(")", "").trim());
    }


    public long two(List<String> puzzleTest) {

        List<String> inst = Arrays.stream(puzzleTest.getFirst().split("")).toList();

        puzzleTest.removeFirst();
        puzzleTest.removeFirst();

        List<Node> nodes = puzzleTest.stream().map(this::buildNode).toList();
        List<Node> starts = nodes.stream().filter(node -> node.data().endsWith("A")).toList();

        //find lcm of all these cyclic
        List<Integer> cycles = starts.stream().mapToInt(node -> findStep2(node, inst, nodes)).boxed().toList();

        int i = 1;
        long res = lcm(cycles.getFirst(), cycles.get(1));
        while (i < cycles.size()-1)
            res = lcm(res, cycles.get(++i));
        return res;
    }

    private int findStep2(Node start, List<String> inst, List<Node> nodes) {
        int i = 0;
        while (!start.data().endsWith("Z")) {
            String next = null;
            if ("R".equals(inst.get(i % inst.size()))) {
                next = start.right();
            } else {
                next = start.left();
            }
            start = applyInst(next, nodes);
            i++;
        }
        return i;
    }

}

record Node(String data, String left, String right) {
}