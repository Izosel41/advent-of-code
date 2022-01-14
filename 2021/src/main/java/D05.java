import java.io.File;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class D05 {

    public long overlap(File df) throws Exception {
        int[][] map = new int[1000][1000];

        Scanner s = new Scanner(df);

        while (s.hasNextLine()) {
            String vent = s.nextLine();
            String[] pos = vent.split(" -> ");
            int[] dep = Arrays.stream(pos[0].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] arr = Arrays.stream(pos[1].split(",")).mapToInt(Integer::parseInt).toArray();

            if (dep[0] == arr[0] || dep[1] == arr[1]) {
                int x1;
                int x2;
                int y1;
                int y2;

                if (dep[0] > arr[0]) {
                    x1 = arr[0];
                    x2 = dep[0];
                } else {
                    x1 = dep[0];
                    x2 = arr[0];
                }

                if (dep[1] > arr[1]) {
                    y1 = arr[1];
                    y2 = dep[1];
                } else {
                    y1 = dep[1];
                    y2 = arr[1];
                }
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        map[y][x] = map[y][x] + 1;
                    }
                }
            }
        }
        s.close();
        return Arrays.stream(map).flatMapToInt(Arrays::stream).filter(x -> x > 1).count();
    }

    public long diagOverlap(File df) throws Exception {
        int[][] map = new int[1000][1000];

        Scanner s = new Scanner(df);

        while (s.hasNextLine()) {
            String vent = s.nextLine();
            String[] pos = vent.split(" -> ");
            int[] dep = Arrays.stream(pos[0].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] arr = Arrays.stream(pos[1].split(",")).mapToInt(Integer::parseInt).toArray();

            int x1;
            int x2;
            int y1;
            int y2;

            if (dep[0] > arr[0] || (dep[0] == arr[0] && dep[1] > arr[1])) {
                y1 = arr[1];
                x1 = arr[0];
                y2 = dep[1];
                x2 = dep[0];
            } else {
                y1 = dep[1];
                x1 = dep[0];
                y2 = arr[1];
                x2 = arr[0];
            }
            //straight
            if (dep[0] == arr[0] || dep[1] == arr[1]) {
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        map[y][x] = map[y][x] + 1;
                    }
                }
            } else {
                //diags
                int diffX = x2 - x1;
                int diffY = y2 - y1;

                for (int i = 0; i <= Math.abs(diffX); i++) {
                    if (diffY > 0) {
                        map[y1 + i][x1 + i] = map[y1 + i][x1 + i] + 1;

                    } else {
                        map[y1 - i][x1 + i] = map[y1 - i][x1 + i] + 1;
                    }
                }
            }
        }

        s.close();
        return Arrays.stream(map).flatMapToInt(Arrays::stream).filter(x -> x > 1).count();
    }
}
