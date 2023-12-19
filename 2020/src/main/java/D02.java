import java.util.List;

class D02 {

    /**
     * "1-3 a: abcde"
     *
     * @param log
     * @return
     */
    boolean validateSled(String log) {

        String[] rule = log.split(":");
        String policy = rule[0];
        String pass = rule[1];

        String[] p = policy.split(" ");
        long min = Long.parseLong(p[0].split("-")[0]);
        long max = Long.parseLong(p[0].split("-")[1]);

        char letter = p[1].charAt(0);

        long occurrence = pass.chars().filter(c -> c == letter).count();

        return min <= occurrence && occurrence <= max;
    }

    public boolean validateToboggan(String log) {

        String[] rule = log.split(":");
        String policy = rule[0];
        String pass = rule[1];

        String[] p = policy.split(" ");

        char letter = p[1].charAt(0);

        char first = pass.charAt(Integer.valueOf(p[0].split("-")[0]));
        char second = pass.charAt(Integer.valueOf(p[0].split("-")[1]));

        if (first == letter && second == letter)
            return false;
        else if (first == letter || second == letter)
            return true;
        else
            return false;
    }
}
