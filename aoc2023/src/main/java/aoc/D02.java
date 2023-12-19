package aoc;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class D02 {

    //12 red cubes, 13 green cubes, and 14 blue cubes?
    public int one(List<String> puzzle) {
        Pattern blue = Pattern.compile("\\d+(?= blue)");
        Pattern green = Pattern.compile("\\d+(?= green)");
        Pattern red = Pattern.compile("\\d+(?= red)");

        int res = 0;
        for (int i = 0; i < puzzle.size(); i++) {
            boolean game = true;
            for (String draw : puzzle.get(i).split(";")) {
                int b = blue.matcher(draw).results().map(MatchResult::group).mapToInt(Integer::parseInt).sum();
                int g = green.matcher(draw).results().map(MatchResult::group).mapToInt(Integer::parseInt).sum();
                int r = red.matcher(draw).results().map(MatchResult::group).mapToInt(Integer::parseInt).sum();

                if (r > 12 || g > 13 || b > 14)
                    game = false;
            }
            if (game)
                res += i + 1;
        }
        return res;
    }


    public int two(List<String> puzzle) {
        Pattern blue = Pattern.compile("\\d+(?= blue)");
        Pattern green = Pattern.compile("\\d+(?= green)");
        Pattern red = Pattern.compile("\\d+(?= red)");

        int res = 0;
        for (int i = 0; i < puzzle.size(); i++) {
            int b = blue.matcher(puzzle.get(i)).results().map(MatchResult::group).mapToInt(Integer::parseInt).max().getAsInt();
            int g = green.matcher(puzzle.get(i)).results().map(MatchResult::group).mapToInt(Integer::parseInt).max().getAsInt();
            int r = red.matcher(puzzle.get(i)).results().map(MatchResult::group).mapToInt(Integer::parseInt).max().getAsInt();
            res += b * g * r;
        }
        return res;
    }

}
