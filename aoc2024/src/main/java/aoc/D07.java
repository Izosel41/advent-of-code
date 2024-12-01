package aoc;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class D07 {

    public int one(List<String> puzzleTest) {
        List<PokerHand> deals = puzzleTest.stream().map(PokerHand::buildPokerHand).sorted((o1, o2) -> compareHands(o1.getHand(), o2.getHand())).toList();
        int res = 0;
        for (int i = 0; i < deals.size(); i++) {
            res = res + deals.get(i).getBid() * (i + 1);
        }
        return res;
    }


    public int two(List<String> puzzleTest) {
        List<PokerHand> deals = puzzleTest.stream().map(PokerHand::buildPokerHand).sorted((o1, o2) -> compareHandsWithJoker(o1.getHand(), o2.getHand())).toList();
        int res = 0;
        for (int i = 0; i < deals.size(); i++) {
            System.out.println(deals.get(i).getHand());
            res = res + deals.get(i).getBid() * (i + 1);
        }
        return res;
    }

    public int compareHands(String hand0, String hand1) {
        int res = Long.compare(
                valueOfHand(Arrays.stream(hand0.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream().sorted().toList()),
                valueOfHand(Arrays.stream(hand1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream().sorted().toList()));

        if (res == 0) {
            //compare highest value
            res = compareHighestValue(hand0, hand1);
        }
        if (res == 0) {
            int j = 0;
            while (res == 0) {
                res = compareCards(hand0.charAt(j), hand1.charAt(j));
                j++;
            }
            return res;
        } else {
            return res;
        }
    }

    private int compareHighestValue(String hand0, String hand1) {
        int i = 0;
        int res = 0;
        while (i < Math.min(hand0.length(), hand1.length()) && res == 0) {
            res = this.compareCards(hand0.charAt(i), hand1.charAt(i));
            i++;
        }
        return res;
    }

    private int compareHighestValueWithJoker(String hand0, String hand1) {
        int i = 0;
        int res = 0;
        while (i < Math.min(hand0.length(), hand1.length()) && res == 0) {
            res = this.compareCardsWithJoker(hand0.charAt(i), hand1.charAt(i));
            i++;
        }
        return res;
    }

    private int compareCards(char c, char c1) {
        Dictionary<Character, Integer> cardValue = new Hashtable<>();
        cardValue.put('A', 14);
        cardValue.put('K', 13);
        cardValue.put('Q', 12);
        cardValue.put('J', 11);
        cardValue.put('T', 10);
        cardValue.put('9', 9);
        cardValue.put('8', 8);
        cardValue.put('7', 7);
        cardValue.put('6', 6);
        cardValue.put('5', 5);
        cardValue.put('4', 4);
        cardValue.put('3', 3);
        cardValue.put('2', 2);

        return Integer.compare(cardValue.get(c), cardValue.get(c1));
    }


    public int compareHandsWithJoker(String hand0, String hand1) {
        Map<String, Long> cards0 = Arrays.stream(hand0.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> cards1 = Arrays.stream(hand1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int res = Long.compare(
                valueOfHandWithJoker(cards0, new ArrayList<>(cards0.values().stream().sorted().toList())),
                valueOfHandWithJoker(cards1, new ArrayList<>(cards1.values().stream().sorted().toList())));

        if (res == 0) {
            //compare highest value
            res = compareHighestValueWithJoker(hand0, hand1);
        }
        if (res == 0) {
            int j = 0;
            while (res == 0) {
                res = compareCardsWithJoker(hand0.charAt(j), hand1.charAt(j));
                j++;
            }
            return res;
        } else {
            return res;
        }
    }

    private int compareCardsWithJoker(char c, char c1) {
        Dictionary<Character, Integer> cardValue = new Hashtable();
        cardValue.put('A', 14);
        cardValue.put('K', 13);
        cardValue.put('Q', 12);
        cardValue.put('T', 10);
        cardValue.put('9', 9);
        cardValue.put('8', 8);
        cardValue.put('7', 7);
        cardValue.put('6', 6);
        cardValue.put('5', 5);
        cardValue.put('4', 4);
        cardValue.put('3', 3);
        cardValue.put('2', 2);
        cardValue.put('J', 1);

        return Integer.compare(cardValue.get(c), cardValue.get(c1));
    }

    private int valueOfHandWithJoker(Map<String, Long> cards, List<Long> cardOccurences) {

        if (Objects.nonNull(cards.get("J")) && cards.get("J")!=5) {
            cardOccurences.remove(cards.get("J"));
            cardOccurences.set(cardOccurences.size() - 1, cardOccurences.getLast() + cards.get("J"));
        }

        return valueOfHand(cardOccurences);
    }

    private int valueOfHand(List<Long> cardOccurences) {

        if (cardOccurences.size() == 1) return 6;

        else if (cardOccurences.size() == 2) {
            if (cardOccurences.getFirst() == 4 || cardOccurences.getLast() == 4)
                // four of a kind
                return 5;
                //full-house
            else return 4;
        } else if (cardOccurences.size() == 3) {
            if (cardOccurences.getLast() == 3 || cardOccurences.getFirst() == 3)
                //three of a kind
                return 3;
            else
                // two pairs
                return 2;
        } else if (cardOccurences.size() == 4) {
            // one pair
            return 1;
        } else return 0;
    }
}

@Data
class PokerHand {
    String hand;
    Integer bid;

    public static PokerHand buildPokerHand(String input) {
        PokerHand p = new PokerHand();
        String[] args = input.split(" ");
        p.hand = args[0];
        p.bid = Integer.parseInt(args[1]);
        return p;
    }
}