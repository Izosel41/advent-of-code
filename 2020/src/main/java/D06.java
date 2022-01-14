import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

public class D06 {

    public int sumYes(File f) throws FileNotFoundException {
        int yes = 0;
        Scanner sc = new Scanner(f);

        String group = "";
        while (sc.hasNext()) {
            String curLine = sc.nextLine();
            if ("".equals(curLine)) {
                yes = yes + countYes(group);
                group = "";
            }
            group = group.concat(curLine);
        }
        //last line
        yes = yes + countYes(group);
    return yes;
    }

    private int countYes(String group) {
        return group.chars().mapToObj(c -> String.valueOf((char) c)).collect(groupingBy(String::toString)).size();
    }

    public int sumAllYes(File f) throws FileNotFoundException {
        int yes = 0;
        int people =0;
        Scanner sc = new Scanner(f);

        List<String> group = new ArrayList<>();
        while (sc.hasNext()) {
            String curLine = sc.nextLine();

            if ("".equals(curLine)) {
                yes = yes + countAllYes(group, people);

                group = new ArrayList<>();
                people = 0;
            }else {
                group.add(curLine);
                people++;
            }
        }
        //last line
        yes = yes + countAllYes(group, people);
        return yes;
    }

    private int countAllYes(List<String> group, int people) {
        List<Set<String>> answers = new ArrayList<>();
        for(String answer : group){
            answers.add(answer.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toSet()));
        }

        Set<String> start = answers.get(0);

        for(Set answer : answers){
            start.retainAll(answer);
        }
        return start.size();
    }
}
