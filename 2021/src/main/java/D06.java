import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class D06 {

    public int[] lanternfish(int[] oldGen, int day) {
        int[] newGen = new int[0];
        for (int d = day; d > 0; d--) {
            int father = Math.toIntExact(Arrays.stream(oldGen).filter(x -> x == 0).count());
            newGen = new int[oldGen.length + father];
            int son = 0;
            for (int i = 0; i < oldGen.length; i++) {
                if (oldGen[i] == 0) {
                    son = son + 1;
                    newGen[i] = 6;
                    newGen[oldGen.length - 1 + son] = 8;
                } else {
                    newGen[i] = oldGen[i] - 1;
                }
            }
            oldGen = newGen;
        }
        return newGen;
    }

    public long members(int[] oldGen, int day) {

        List<Integer> input = Arrays.stream(oldGen).boxed().toList();

        long[] counts = new long[9];
        for (Integer fish : input) {
            counts[fish]++;
        }
        for (int i = 0; i < day; i++) {
            long[] newGenerationCounts = new long[9];
            newGenerationCounts[8] = counts[0];
            newGenerationCounts[7] = counts[8];
            newGenerationCounts[6] = counts[7] + counts[0];
            newGenerationCounts[5] = counts[6];
            newGenerationCounts[4] = counts[5];
            newGenerationCounts[3] = counts[4];
            newGenerationCounts[2] = counts[3];
            newGenerationCounts[1] = counts[2];
            newGenerationCounts[0] = counts[1];
            counts = Arrays.copyOf(newGenerationCounts, 9);
        }
        return LongStream.of(counts).sum();
    }
}