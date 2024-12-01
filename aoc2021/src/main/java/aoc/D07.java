package aoc;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class D07 {

    public int fuel(int[] positions) {
        IntSummaryStatistics stats = Arrays.stream(positions).summaryStatistics();
        int res = stats.getMax() * positions.length;

        for(int x=stats.getMin(); x<stats.getMax();x++){
            int finalX = x;
            int hyp = Arrays.stream(positions).map(p -> Math.abs(p- finalX)).sum();
            if(hyp<res)
                res = hyp;
        }
        return res;
    }

    public int fuel2(int[] positions) {
        IntSummaryStatistics stats = Arrays.stream(positions).summaryStatistics();
        int res = 999999999;

        for(int x=stats.getMin(); x<stats.getMax();x++){
            int finalX = x;
            int hyp = Arrays.stream(positions).map(p -> f(Math.abs(p- finalX))).sum();
            if(hyp<res)
                res = hyp;
        }
        return res;
    }

    private int f(int x) {
        int res = 0;
        for(int i = x;x>0;x--){
            res = res + x;
        }
        return res;
    }
}
