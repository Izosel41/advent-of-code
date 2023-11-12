package aoc;

import lombok.Data;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class D11 {

    public int one(List<Monkey> monkeys, int r) {

        for (int round = 0; round < r; round++) {
            System.out.println("** Round" + round);
            for (Monkey m : monkeys) {
                while (!m.getItems().isEmpty()) {
                    m.setInspect(m.getInspect() + 1);
//                    System.out.println("aoc.Monkey " + monkey + " inspects " + m.getInspect());
                    long item = m.getItems().removeFirst();
//                    System.out.println("  " + item);
                    item = m.getOp().op(item);
//                    System.out.println("  " + item);
                    item = (int) Math.ceil(item / 3);
//                    System.out.println("  " + item);
                    int next = (int) m.getTest().op(item);
//                    System.out.println("  " + next);
                    monkeys.get(next).getItems().addLast(item);
                }
            }
        }

        return monkeys.stream().map(Monkey::getInspect).sorted(Comparator.reverseOrder()).limit(2).reduce((a, b) -> a * b).orElse(0);
    }


    public Long two(List<Monkey> monkeys, int r, int gcd) {
        for (int round = 0; round < r; round++) {

            for (Monkey value : monkeys) {

                while (!value.getItems().isEmpty()) {
                    Monkey m = value;
                    m.setInspect(m.getInspect() + 1);

                    long item = m.getItems().removeFirst();
                    item = m.getOp().op(item);

                    item = item % gcd;
                    int next = (int) m.getTest().op(item);
                    monkeys.get(next).getItems().addLast(item);
                }
            }
        }

        return monkeys.stream()
                .map(Monkey::getInspect)
                .sorted(Comparator.reverseOrder())
                .limit(2).mapToLong(Long::valueOf).reduce((a, b) -> a * b).orElse(0);

    }

    @Data
    static
    class Monkey {
        private int inspect = 0;
        private LinkedList<Long> items = null;

        private Operation op = null;

        private Operation test = null;

        @Override
        public String toString() {
            return "aoc.D11.Monkey{" +
                    "inspect=" + inspect +
                    ", items=" + items +
                    '}';
        }
    }

    static interface Operation {
        long op(long old);
    }
}
