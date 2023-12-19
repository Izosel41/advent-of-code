class D03 {

    public int meetTrees(int xShift, int yShift, char[][] input, int width, int height) {
        int x = 0;
        int y = 0;
        int tree = 0;

        while (y + yShift < height) {

            if (x + xShift >= width)
                x = x + xShift - width;
            else
                x = x + xShift;

            y = y + yShift;

            if (input[y][x] == '#') {
                tree++;
            }
        }
        return tree;
    }
}
