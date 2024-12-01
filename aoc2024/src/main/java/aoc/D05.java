package aoc;

import lombok.Data;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class D05 {
    public Long one(List<String> puzzleTest) {
        List<Rule> seedToSoilRules = new ArrayList<>();
        List<Rule> soilToFertilizer = new ArrayList<>();
        List<Rule> fertilizerToWater = new ArrayList<>();
        List<Rule> waterToLight = new ArrayList<>();
        List<Rule> lightToTemperature = new ArrayList<>();
        List<Rule> temperatureToHumidity = new ArrayList<>();
        List<Rule> humidityToLocation = new ArrayList<>();

        List<Long> seeds = Arrays.stream(puzzleTest.getFirst().split(": ")[1].split(" "))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .boxed().toList();

        int i = 3;
        while (!puzzleTest.get(i).isEmpty()) {
            seedToSoilRules.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            soilToFertilizer.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            fertilizerToWater.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            waterToLight.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            lightToTemperature.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            temperatureToHumidity.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (i < puzzleTest.size() && !puzzleTest.get(i).isEmpty()) {
            humidityToLocation.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" ")).map(String::trim)));
            i++;
        }

        return seeds.stream()
                .map(seed -> applyRules(seedToSoilRules, seed))
                .map(soil -> applyRules(soilToFertilizer, soil))
                .map(fertilizer -> applyRules(fertilizerToWater, fertilizer))
                .map(water -> applyRules(waterToLight, water))
                .map(light -> applyRules(lightToTemperature, light))
                .map(temp -> applyRules(temperatureToHumidity, temp))
                .map(hum -> applyRules(humidityToLocation, hum))
                .min(Comparator.comparing(Long::valueOf))
                .get();
    }

    private Rule buildRule(Stream<String> puzzleTest) {
        List<Long> ruleElements =
                puzzleTest.mapToLong(Long::parseLong).boxed().toList();
        Rule r = new Rule(ruleElements.get(0), ruleElements.get(1), ruleElements.get(2));
        return r;
    }

    private Long applyRules(List<Rule> rules, Long seed) {
        Optional<Rule> ruleToApply = rules.stream().filter(r -> r.isAppliable(seed)).findFirst();
        if (ruleToApply.isEmpty())
            return seed;
        else
            return ruleToApply.get().apply(seed);
    }


    public Long two(List<String> puzzleTest) throws InterruptedException {
        List<Rule> seedToSoilRules = new ArrayList<>();
        List<Rule> soilToFertilizer = new ArrayList<>();
        List<Rule> fertilizerToWater = new ArrayList<>();
        List<Rule> waterToLight = new ArrayList<>();
        List<Rule> lightToTemperature = new ArrayList<>();
        List<Rule> temperatureToHumidity = new ArrayList<>();
        List<Rule> humidityToLocation = new ArrayList<>();

        List<Long> seedRanges = Arrays.stream(puzzleTest.getFirst().split(": ")[1].split(" "))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .boxed().toList();

        int i = 3;
        while (!puzzleTest.get(i).isEmpty()) {
            seedToSoilRules.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            soilToFertilizer.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            fertilizerToWater.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            waterToLight.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            lightToTemperature.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (!puzzleTest.get(i).isEmpty()) {
            temperatureToHumidity.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" "))
                    .map(String::trim)));
            i++;
        }

        i += 2;
        while (i < puzzleTest.size() && !puzzleTest.get(i).isEmpty()) {
            humidityToLocation.add(buildRule(Arrays.stream(puzzleTest.get(i).split(" ")).map(String::trim)));
            i++;
        }

        //Split by threads
        List<Long> res = new ArrayList<>();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
        List<CalcTask> tasks = new ArrayList<>();
            CalcTask t = new CalcTask();
            t.seedToSoilRules = seedToSoilRules;
            t.soilToFertilizer = soilToFertilizer;
            t.fertilizerToWater = fertilizerToWater;
            t.waterToLight = waterToLight;
            t.lightToTemperature = lightToTemperature;
            t.temperatureToHumidity = temperatureToHumidity;
            t.humidityToLocation = humidityToLocation;

            for (int task = 0; task < 1_000 / 2; task++) {

                for (int j = 0; j < seedRanges.size(); j = j + 2) {
                    List<Long> seeds = new ArrayList<>();
                    Long start = seedRanges.get(j);
                    Long range = seedRanges.get(j + 1);

                    for (int k = 0; k < range; k++) {
                        seeds.add(start + k);
                    }
                    t.seeds = seeds;
                }
                tasks.add(t);
            }

            List<Future<Long>> taskFutureList = executor.invokeAll(tasks);

            for (Future<Long> future : taskFutureList) {
                res.add(future.get());
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        return res.stream().min(Comparator.comparing(Long::valueOf)).get();
    }

    public Long seedToSoil(String ruleDef, Long seed) {
        Rule rule = buildRule(Arrays.stream(ruleDef.split(" ")));
        return rule.apply(seed);
    }
}

@Data
class Rule {
    Long destinationStart;
    Long sourceStart;
    Long range;

    public Rule(Long destinationStart, Long sourceStart, Long range) {
        this.destinationStart = destinationStart;
        this.sourceStart = sourceStart;
        this.range = range;

    }

    Long apply(Long seed) {
        if (isAppliable(seed))
            return destinationStart + (seed - sourceStart);
        else
            return seed;
    }

    boolean isAppliable(Long seed) {
        return sourceStart <= seed
                && seed < sourceStart + range;
    }
}

class CalcTask implements Callable<Long> {
    List<Long> seeds;
    List<Rule> seedToSoilRules;
    List<Rule> soilToFertilizer;
    List<Rule> fertilizerToWater;
    List<Rule> waterToLight;
    List<Rule> lightToTemperature;
    List<Rule> temperatureToHumidity;
    List<Rule> humidityToLocation;

    private Long applyRules(List<Rule> rules, Long seed) {
        Optional<Rule> ruleToApply = rules.stream().filter(r -> r.isAppliable(seed)).findFirst();
        if (ruleToApply.isEmpty())
            return seed;
        else
            return ruleToApply.get().apply(seed);
    }

    public Long call() {

        Long res = seeds.stream()
                .map(seed -> applyRules(seedToSoilRules, seed))
                .map(soil -> applyRules(soilToFertilizer, soil))
                .map(fertilizer -> applyRules(fertilizerToWater, fertilizer))
                .map(water -> applyRules(waterToLight, water))
                .map(light -> applyRules(lightToTemperature, light))
                .map(temp -> applyRules(temperatureToHumidity, temp))
                .map(hum -> applyRules(humidityToLocation, hum))
                .peek(System.out::println)
                .min(Comparator.comparing(Long::valueOf))
                .get();
        System.out.println(res);
        return res;
    }
}