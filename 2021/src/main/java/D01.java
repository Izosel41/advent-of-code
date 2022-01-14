class D01 {

    public int countIncreased(int[] depths) {
        int increased = 0;

        for (int i = 1; i < depths.length; i++) {
            if (depths[i] > depths[i - 1]) {
                increased++;
            }
        }
        return increased;
    }

    public int countSliding(int[] depths) {
        int increased = 0;

        for (int i = 0; i < depths.length - 3; i++) {
            if (depths[i] + depths[i + 1] + depths[i + 2] < depths[i + 1] + depths[i + 2] + depths[i + 3]) {
                increased++;
            }
        }
        return increased;
    }
}
