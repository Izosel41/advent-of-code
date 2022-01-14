import java.io.File;
import java.nio.ByteBuffer;
import java.util.*;

class D03 {

    public List<String> buildDiag(File df) throws Exception {
        Scanner s = new Scanner(df);
        List<String> diags = new ArrayList<>();

        while (s.hasNextLine()) {
            diags.add(s.nextLine());
        }
        s.close();
        return diags;
    }

    public int[] consumption(List<String> diags) {
        int[] sums = new int[diags.get(0).length()];

        for (int row = 0; row < diags.get(0).length(); row++) {
            for (int line = 0; line < diags.size(); line++) {
                char bit = diags.get(line).charAt(row);
                sums[row] += Character.getNumericValue(bit);
            }
        }

        String gamma = "";
        for (int x = 0; x < sums.length; x++) {
            if (sums[x] < diags.size() / 2)
                gamma = gamma + "0";
            else
                gamma = gamma + "1";
        }
        String epsilon = gamma;
        epsilon = epsilon.replace("0", "a");
        epsilon = epsilon.replace("1", "0");
        epsilon = epsilon.replace("a", "1");
        return new int[]{Integer.parseInt(gamma, 2)
                , Integer.parseInt(epsilon, 2)};
    }

    public int[] lifeSupport(List<String> diags) {
        int o2 = common(diags, 0, 1);
        int co2 = common(diags, 0, -1);
        System.out.println(o2);
        System.out.println(co2);
        return new int[]{o2,co2};
    }

    private int common(List<String> diags, int row, int significant) {
        if (diags.size() == 1) {
            String rate = "";
            for (int i = 0; i < diags.get(0).length(); i++) {
                rate = rate + diags.get(0).charAt(i);
            }
            return Integer.parseInt(rate, 2);
        } else {
            List<String> list0 = new ArrayList();
            List<String> list1 = new ArrayList();
            for (int l = 0; l < diags.size(); l++) {
                if (diags.get(l).charAt(row) == 48) //char(48) is 0
                    list0.add(diags.get(l));
                else
                    list1.add(diags.get(l));
            }

            if (list0.size() > list1.size() && significant > 0)
                return common(list0, ++row, significant);
            if (list0.size() < list1.size() && significant > 0)
                return common(list1, ++row, significant);
            if (list0.size() == list1.size() && significant > 0)
                return common(list0.get(0).charAt(row) != 48 ? list0 : list1, ++row, significant);

            if (list0.size() > list1.size() && significant < 0)
                return common(list1, ++row, significant);
            if (list0.size() < list1.size() && significant < 0)
                return common(list0, ++row, significant);
            if (list0.size() == list1.size() && significant < 0)
                return common(list0.get(0).charAt(row) == 48 ? list0 : list1, ++row, significant);

        }
        return -1;
    }
}
