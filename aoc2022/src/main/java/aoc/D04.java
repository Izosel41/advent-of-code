package aoc;

import java.util.Arrays;
import java.util.List;

class D04 {

    public int contains(List<String> puzzles) {
        return puzzles.stream()
                .mapMultiToInt((s, intConsumer) -> {
                            String[] pairs = s.split(",");
                            int[] borns0 = Arrays.stream(pairs[0].split("-")).mapToInt(Integer::valueOf).toArray();
                            int[] borns1 = Arrays.stream(pairs[1].split("-")).mapToInt(Integer::valueOf).toArray();

                            if ((borns0[0] <= borns1[0] && borns0[1] >= borns1[1]) ||
                                    (borns0[0] >= borns1[0] && borns0[1] <= borns1[1]))
                                intConsumer.accept(1);
                        }
                ).sum();
    }

    public int overlap(List<String> puzzles) {
        return puzzles.stream()
                .mapMultiToInt((s, intConsumer) -> {
                            String[] pairs = s.split(",");
                            int[] borns0 = Arrays.stream(pairs[0].split("-")).mapToInt(Integer::valueOf).toArray();
                            int[] borns1 = Arrays.stream(pairs[1].split("-")).mapToInt(Integer::valueOf).toArray();

                            if ((borns0[0] <= borns1[0] && borns0[1] >= borns1[0]) ||
                                    (borns0[1] >= borns1[0] && borns0[0] <= borns1[1]))
                                intConsumer.accept(1);
                        }
                ).sum();
    }
}
