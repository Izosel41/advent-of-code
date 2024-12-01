package aoc;


import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

class D04 {
    int[] orders;

    public List<Integer[][]> initBingo(File df) throws Exception {
        List<Integer[][]> cards = new ArrayList<>();

        Scanner s = new Scanner(df);
        orders = Arrays.stream(s.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Integer[][] card = new Integer[5][5];
        s.nextLine();
        int i = 0;

        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (StringUtils.isEmpty(line)) {
                cards.add(card);
                card = new Integer[5][5];
                i = 0;
            } else {
                for (int j = 0; j < 5; j++) {
                    line = line.replace("  ", " ");
                    line = line.trim();
                    String[] num = line.split(" ");
                    card[i][j] = Integer.parseInt(num[j]);
                }
                i++;
            }
        }
        cards.add(card);
        s.close();
        return cards;
    }

    public int bingo(List<Integer[][]> cards) {
        int sum = 0;
        int order = -1;
        int cpt = 0;
        int x = 0;
        int y = 0;

        while (sum == 0) {
            order = orders[cpt];

            for (Integer[][] card : cards) {
                for (x = 0; x < 5; x++) {
                    for (y = 0; y < 5; y++) {
                        if (order == card[x][y]) {
//                            System.out.printf("Found %s at %s %s", order, x, y);
//                            System.out.println("");
                            card[x][y] = 0;
                            //check success
                            int line = Arrays.stream(card[x])
                                    .mapToInt(Integer::intValue)
                                    .sum();

                            final int finalY = y;
                            int row = Arrays.stream(card)
                                    .mapToInt(arr -> arr[finalY])
                                    .sum();

                            if (line == 0 || row == 0) {
                                sum = Arrays.stream(card).mapToInt(l -> Arrays.stream(l).mapToInt(b -> b).sum()).sum();
                                break;
                            }
                        }
                    }
                }
            }

            cpt++;
        }
        System.out.println("order=" + order);
        System.out.println("sum=" + sum);
        return order * sum;
    }

    public int lastBingo(List<Integer[][]> cards) {
        int sum = 0;
        int order = -1;
        int cpt = 0;

        int z =0;

        while (sum == 0) {
            order = orders[cpt];

            for (int c = 0; c < cards.size(); c++) {
                Integer[][] card = cards.get(c);
                if (card != null) {
                    for (int x = 0; x < 5; x++) {
                        for (int y = 0; y < 5; y++) {
                            if (order == card[x][y]) {
                                card[x][y] = 0;
                                //check success
                                int line = Arrays.stream(card[x])
                                        .mapToInt(Integer::intValue)
                                        .sum();

                                final int finalY = y;
                                int row = Arrays.stream(card)
                                        .mapToInt(arr -> arr[finalY])
                                        .sum();

                                if (line == 0 || row == 0) {
                                    sum = Arrays.stream(card).mapToInt(l -> Arrays.stream(l).mapToInt(b -> b).sum()).sum();

                                    if (z < cards.size()-1) {
                                        cards.set(c, null);
                                        z++;
                                        y = 5;
                                        x = 5;
                                        sum = 0;
                                    } else {
                                        break;
                                    }

                                }
                            }
                        }
                    }
                }
            }
            cpt++;
        }
        System.out.println("order=" + order);
        System.out.println("sum=" + sum);
        return order * sum;
    }
}
