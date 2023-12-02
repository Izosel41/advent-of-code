package aoc;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D01 {

    public int one(List<String> lines) {
        return lines.stream()
                .mapToInt(this::calibrate)
                .sum();
    }

    public int calibrate(String line) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(line);
        String first = null;
        String last = null;

        while (matcher.find()) {
            if (Objects.isNull(first))
                first = matcher.group();
            else
                last = matcher.group();
        }
        if (Objects.isNull(last))
            last = first;
        return Integer.parseInt(first + last);
    }


    public int fineCalibrate(String line) {
        //cannot find a better way to handle these cases
        line = line.replace("eightwo", "eighttwo");
        line = line.replace("twone", "twoone");
        line = line.replace("threeight", "threeeight");
        line = line.replace("oneight", "oneeight");

        Pattern pattern = Pattern.compile("(\\d|one|two|three|four|five|six|seven|eight|nine)");
        Matcher matcher = pattern.matcher(line);
        String first = null;
        String last = null;

        while (matcher.find()) {
            if (Objects.isNull(first))
                first = matcher.group();
            else
                last = matcher.group();
        }
        if (Objects.isNull(last))
            last = first;

        return Integer.parseInt(translate(first) + translate(last));
    }

    private String translate(String word) {
        return switch (word) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> word;
        };
    }

    public int two(List<String> lines) {
        return lines.stream()
                .mapToInt(this::fineCalibrate)
                .sum();
    }

}
