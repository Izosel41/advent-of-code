import java.util.List;

class D10 {
    int cycle = 0;

    public int one(List<String> puzzle) {
        int signal = 0;
        int x = 1;
        for (String cmd : puzzle) {
            String op = cmd.substring(0, 4);

            switch (op) {
                case "noop" -> signal = signal + increaseCycle(x);
                case "addx" -> {
                    int v = Integer.parseInt(cmd.substring(5));
                    signal = signal + increaseCycle(x);
                    signal = signal + increaseCycle(x);
                    x = x + v;
                }
            }
        }
        return signal;
    }

    private int increaseCycle(int x) {
        cycle++;
        if (cycle == 20)
            return 20 * x;
        else if (cycle % 40 == 20)
            return cycle * x;
        else
            return 0;
    }

    public String two(List<String> puzzle) {
        StringBuilder sb = new StringBuilder();
        int x = 1;
        for (String cmd : puzzle) {
            String op = cmd.substring(0, 4);

            switch (op) {
                case "noop" -> sb.append(increaseCycle2(x));
                case "addx" -> {
                    int v = Integer.parseInt(cmd.substring(5));
                    sb.append(increaseCycle2(x));
                    sb.append(increaseCycle2(x));
                    x = x + v;
                }
            }
        }

        return sb.toString();
    }

    private String increaseCycle2(int x) {
       String crt = "";
        if (cycle % 40 == x-1 || cycle% 40  == x || cycle% 40  == x+1)
            crt = "#";
        else
            crt = ".";
        cycle++;

       return crt;
    }
}