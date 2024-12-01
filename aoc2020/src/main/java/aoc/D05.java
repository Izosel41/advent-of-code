package aoc;

import java.util.List;
import java.util.stream.Collectors;

class D05 {

    class Range {
        int min;
        int max;

        public Range(int x, int y){
            this.min = x;
            this.max = y;
        }
    }

    enum Region {

        F {
            @Override
            public Range reduce(Range range) {
                range.max = (range.min+range.max-1) / 2 ;
                return range;
            }
        },

        B {
            @Override
            public Range reduce(Range range) {
                range.min = (range.min+range.max+1) / 2;
                return range;
            }
        },

        L {
            @Override
            public Range reduce(Range range) {
                range.max = (range.min+range.max-1) / 2;
                return range;
            }
        },

        R {
            @Override
            public Range reduce(Range range) {
                range.min = (range.min+range.max+1) / 2;
                return range;
            }
        };

        public abstract Range reduce(Range range);
    }

    public int findSeat(String path){
        List<Region> regionRows =
                path.chars()
                .filter(c->'F'==c || 'B' ==c)
                .mapToObj(c -> String.valueOf((char) c))
                .map(Region::valueOf)
                .collect(Collectors.toList());

        Range curRow = new Range(0,127);
        for (Region region : regionRows) {
            curRow = region.reduce(curRow);
        }

        List<Region> regionColumns =
                path.chars()
                        .filter(c->'L'==c || 'R' ==c)
                        .mapToObj(c -> String.valueOf((char) c))
                        .map(Region::valueOf)
                        .collect(Collectors.toList());

        Range curCol = new Range(0,7);
        for (Region region : regionColumns) {
            curCol = region.reduce(curCol);
        }

        //System.out.println(curRow.min+","+curCol.min);
        return curRow.max*8 +curCol.max;
    }
}
