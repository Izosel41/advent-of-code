package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D04 {
    public double one(List<String> puzzleTest) {
        return puzzleTest.stream().mapToDouble(this::worth).sum();
    }

    private double worth(String line) {
        String[] input = line.split(":")[1].split("\\|");
        List<Integer> winnings = new ArrayList<>(Arrays.stream(input[0].split(" "))
                .filter(s -> !s.trim().isEmpty())
                .mapToInt(Integer::parseInt).boxed().toList());
        List<Integer> numbers = new ArrayList<>(Arrays.stream(input[1].split(" "))
                .filter(s -> !s.trim().isEmpty())
                .mapToInt(Integer::parseInt).boxed().toList());

        int founded = winnings.stream().mapToInt(integer -> numbers.contains(integer) ? 1 : 0).sum();

        if (founded == 0)
            return 0;
        else
            return Math.pow(2, founded - 1);
    }


    public int two(List<String> puzzleTest) {
        List<Integer> cards = new ArrayList();
        List<Integer> winningCards = new ArrayList();

        //init
        for (String line : puzzleTest) {
            String[] input = line.split(":")[1].split("\\|");
            List<Integer> winnings = new ArrayList<>(Arrays.stream(input[0].split(" "))
                    .filter(s -> !s.trim().isEmpty())
                    .mapToInt(Integer::parseInt).boxed().toList());
            List<Integer> numbers = new ArrayList<>(Arrays.stream(input[1].split(" "))
                    .filter(s -> !s.trim().isEmpty())
                    .mapToInt(Integer::parseInt).boxed().toList());

            winningCards.add(winnings.stream().mapToInt(integer -> numbers.contains(integer) ? 1 : 0).sum());
        }

        for (int i = 1; i <= winningCards.size(); i++) {
            cards.add(1);
        }

        for (int i = 0; i < winningCards.size(); i++) {
            int win = winningCards.get(i);
            for (int j = 0; j < cards.get(i); j++) {
                for (int x = i + 1; x <= i + win; x++) {
                    cards.set(x, 1 + cards.get(x));
                }
            }
        }
        return cards.stream().reduce(Integer::sum).get();
    }
}

