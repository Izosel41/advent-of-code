package aoc;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class D08 {

    public long signal(String tf) throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource(tf).toURI());
        return Files.readAllLines(df.toPath()).stream()
                .map(line -> line.split(" \\| ")[1])
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .filter(s -> s.length() == 2 || s.length() == 7 || s.length() == 4 || s.length() == 3)
                .count();
    }

    public long decode(String tf) throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource(tf).toURI());
        List<String> lines = Files.readAllLines(df.toPath());

        Map<Integer, Set<Character>> dict = new HashMap<>();
        for(String line : lines) {
            String[] inputs = line.split(" \\| ")[1].split(" ");
            //usual suspects
            dict.put(1, Arrays.stream(inputs).filter(s -> s.length() == 2).findAny().get().chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toSet()));
            dict.put(4, Arrays.stream(inputs).filter(s -> s.length() == 4).findAny().get().chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toSet()));
            dict.put(7, Arrays.stream(inputs).filter(s -> s.length() == 3).findAny().get().chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toSet()));
            dict.put(8, Arrays.stream(inputs).filter(s -> s.length() == 7).findAny().get().chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toSet()));
            //guesses
        }

        // 3 is a 5 length with 1
//            Set nine = new HashSet<>();
//            nine.addAll(dict.get(4));
//            nine.addAll(dict.get(9));
//            dict.put(9, nine);

//        }
        return 0;
    }
}
