import java.util.List;

public class D11 {

    private char floor = '.';
    private char empty = 'L';
    private char occupied = '#';

    public int countOccupied(List<String> input) {
        char[][] layout = new char[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            layout[i] = input.get(i).toCharArray();
        }

        char[][] finalLayout = process(layout);
        int res = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(0).length(); j++) {
                if (finalLayout[i][j] == occupied)
                    res++;
            }
        }
        return res;
    }

    private char[][] process(char[][] layout) {
        boolean hasChanged = false;
        int height = layout.length;
        int width = layout[0].length;
        char[][] res = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //no change
                if (layout[i][j] == floor)
                    res[i][j] = floor;

                //to be occupied ?
                if (layout[i][j] == empty) {
                    if (checkAdjacentFree(layout, height - 1, width - 1, i, j)) {
                        res[i][j] = occupied;
                        hasChanged = true;
                    } else
                        res[i][j] = empty;

                }
                //to be freed ?
                if (layout[i][j] == occupied) {
                    if (check2b3(layout, height - 1, width - 1, i, j)) {
                        res[i][j] = empty;
                        hasChanged = true;
                    } else
                        res[i][j] = occupied;
                }
            }
        }
        if (hasChanged)
            return process(res);
        else
            return res;
    }

    private boolean checkAdjacentFree(char[][] layout, int height, int width, int i, int j) {
        int nw = 0;
        int n = 0;
        int ne = 0;
        int w = 0;
        int e = 0;
        int sw = 0;
        int s = 0;
        int se = 0;

        if (i > 0 && j > 0) {
            if (layout[i - 1][j - 1] == empty || layout[i - 1][j - 1] == floor)
                nw = 1;
        } else
            nw = 1;

        if (i > 0) {
            if (layout[i - 1][j] == empty || layout[i - 1][j] == floor)
                n = 1;
        } else
            n = 1;

        if (i > 0 && j < width) {
            if (layout[i - 1][j + 1] == empty || layout[i - 1][j + 1] == floor)
                ne = 1;
        } else
            ne = 1;

        if (j > 0) {
            if (layout[i][j - 1] == empty || layout[i][j - 1] == floor)
                w = 1;
        } else
            w = 1;

        if (j < width) {
            if (layout[i][j + 1] == empty || layout[i][j + 1] == floor)
                e = 1;
        } else
            e = 1;

        if (i < height && j > 0) {
            if (layout[i + 1][j - 1] == empty || layout[i + 1][j - 1] == floor)
                sw = 1;
        } else
            sw = 1;

        if (i < height) {
            if (layout[i + 1][j] == empty || layout[i + 1][j] == floor)
                s = 1;
        } else
            s = 1;

        if (i < height && j < width) {
            if (layout[i + 1][j + 1] == empty || layout[i + 1][j + 1] == floor)
                se = 1;
        } else
            se = 1;

        return (nw + n + ne + w + e + sw + s + se) == 8;
    }

    private boolean check2b3(char[][] layout, int height, int width, int i, int j) {

        int nw = 0;
        int n = 0;
        int ne = 0;
        int w = 0;
        int e = 0;
        int sw = 0;
        int s = 0;
        int se = 0;

        if (i > 0 && j > 0)
            if (layout[i - 1][j - 1] == occupied)
                nw = 1;

        if (i > 0) {
            if (layout[i - 1][j] == occupied)
                n = 1;
        }

        if (i > 0 && j < width) {
            if (layout[i - 1][j + 1] == occupied)
                ne = 1;
        }

        if (j > 0) {
            if (layout[i][j - 1] == occupied)
                w = 1;
        }

        if (j < width) {
            if (layout[i][j + 1] == occupied)
                e = 1;
        }

        if (i < height && j > 0) {
            if (layout[i + 1][j - 1] == occupied)
                sw = 1;
        }

        if (i < height) {
            if (layout[i + 1][j] == occupied)
                s = 1;
        }

        if (i < height && j < width) {
            if (layout[i + 1][j + 1] == occupied)
                se = 1;
        }

        return (nw + n + ne + w + e + sw + s + se) > 3;
    }

    public int countOccupied2(List<String> input) {
        char[][] layout = new char[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            layout[i] = input.get(i).toCharArray();
        }

        char[][] finalLayout = process2(layout);
        int res = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(0).length(); j++) {
                if (finalLayout[i][j] == occupied)
                    res++;
            }
        }
        return res;
    }

    private char[][] process2(char[][] layout) {
        boolean hasChanged = false;
        int height = layout.length;
        int width = layout[0].length;
        char[][] res = new char[height][width];

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print(layout[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //no change
                if (layout[i][j] == floor)
                    res[i][j] = floor;

                //to be occupied ?
                if (layout[i][j] == empty) {
                    if (checkVisibleFree(layout, height - 1, width - 1, i, j)) {
                        res[i][j] = occupied;
                        hasChanged = true;
                    } else
                        res[i][j] = empty;

                }
                //to be freed ?
                if (layout[i][j] == occupied) {
                    if (check2b3Visible(layout, height - 1, width - 1, i, j)) {
                        res[i][j] = empty;
                        hasChanged = true;
                    } else
                        res[i][j] = occupied;
                }
            }
        }
        if (hasChanged)
            return process2(res);
        else
            return res;


    }

    private boolean check2b3Visible(char[][] layout, int height, int width, int i, int j) {
        int nw = 0;
        int n = 0;
        int ne = 0;
        int w = 0;
        int e = 0;
        int sw = 0;
        int s = 0;
        int se = 0;

        //related
        int ri = i;
        int rj = j;

        while (ri > 0 && rj > 0 ) {
            if (layout[ri - 1][rj - 1] == floor) {
                ri--;
                rj--;
            } else if (layout[ri - 1][rj - 1] == occupied) {
                nw = 1;
                ri = 0;
            } else if (layout[ri - 1][rj - 1] == empty) {
                ri = 0;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (ri > 0) {
            if (layout[ri - 1][rj] == floor) {
                ri--;
            } else if (layout[ri - 1][rj] == occupied) {
                n = 1;
                ri = -1;
            } else if (layout[ri - 1][rj] == empty) {
                ri = -1;
            }
        }
        //reset
        ri = i;
        rj = j;
        while (ri > 0 && rj < width) {
            if (layout[ri - 1][rj + 1] == floor) {
                ri--;
                rj++;
            } else if (layout[ri - 1][rj + 1] == occupied) {
                ne = 1;
                ri = -1;
            } else if (layout[ri - 1][rj + 1] == empty) {
                ri = -1;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (rj > 0) {
            if (layout[ri][rj - 1] == floor) {
                rj--;
            } else if (layout[ri][rj - 1] == occupied) {
                w = 1;
                rj = -1;
            } else if (layout[ri][rj - 1] == empty) {
                rj = -1;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (rj < width) {
            if (layout[ri][rj + 1] == floor)
                rj++;
            else if (layout[ri][rj + 1] == occupied) {
                rj = width;
                e = 1;
            }else if (layout[ri][rj + 1] == empty) {
                rj = width;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (ri < height && rj > 0) {
            if (layout[ri + 1][rj - 1] == floor) {
                ri++;
                rj--;
            } else if (layout[ri + 1][rj - 1] == occupied) {
                sw = 1;
                rj = 0;
            }else if (layout[ri + 1][rj - 1] == empty) {
                rj = 0;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (ri < height) {
            if (layout[ri + 1][rj] == floor) {
                ri++;
            } else if (layout[ri + 1][rj] == occupied) {
                s = 1;
                ri = height;
            } else if (layout[ri + 1][rj] == empty) {
                ri = height;
            }
        }

        //reset
        ri = i;
        rj = j;
        while (ri < height && rj < width) {
            if (layout[ri + 1][rj + 1] == floor) {
                ri++;
                rj++;
            } else if (layout[ri + 1][rj + 1] == occupied) {
                se = 1;
                ri = height;
            } else if (layout[ri + 1][rj + 1] == empty) {
                ri = height;
            }
        }

        return (nw + n + ne + w + e + sw + s + se) > 4;
    }

    private boolean checkVisibleFree(char[][] layout, int height, int width, int i, int j) {
        int nw = 0;
        int n = 0;
        int ne = 0;
        int w = 0;
        int e = 0;
        int sw = 0;
        int s = 0;
        int se = 0;

        //related
        int ri = i;
        int rj = j;

        while (ri > 0 && rj > 0) {
            if (layout[ri - 1][rj - 1] == floor) {
                ri--;
                rj--;
            } else if (layout[ri - 1][rj - 1] == empty) {
                nw = 1;
                ri = 0;
            } else if (layout[ri - 1][rj - 1] == occupied) {
                ri = -1;
            }
        }
        //ri or rj were equals to 0 at start
        if (ri == 0 || rj == 0)
            nw = 1;

        //reset
        ri = i;
        rj = j;
        while (ri > 0) {
            if (layout[ri - 1][rj] == floor) {
                ri--;
            } else if (layout[ri - 1][rj] == empty) {
                n = 1;
                ri = -1;
            } else if (layout[ri - 1][rj] == occupied) {
                ri = -1;
            }
        }
        if (ri == 0)
            n = 1;

        //reset
        ri = i;
        rj = j;
        while (ri > 0 && rj < width) {
            if (layout[ri - 1][rj + 1] == floor) {
                ri--;
                rj++;
            } else if (layout[ri - 1][rj + 1] == empty) {
                ne = 1;
                ri = -1;
            } else if (layout[ri - 1][rj + 1] == occupied) {
                ri = -1;
            }
        }
        if (ri == 0 || rj == width)
            ne = 1;

        //reset
        ri = i;
        rj = j;
        while (rj > 0) {
            if (layout[ri][rj - 1] == floor) {
                rj--;
            } else if (layout[ri][rj - 1] == empty) {
                w = 1;
                rj = -1;
            }else if (layout[ri][rj - 1] == occupied) {
                rj = -1;
            }
        }
        if (rj == 0)
            w = 1;

        //reset
        ri = i;
        rj = j;
        while (rj < width) {
            if (layout[ri][rj + 1] == floor)
                rj++;
            else if (layout[ri][rj + 1] == empty) {
                rj = width;
                e = 1;
            } else if (layout[ri][rj + 1] == occupied) {
                rj = width+1;
            }
        }
        if (rj == width)
            e = 1;

        //reset
        ri = i;
        rj = j;
        while (ri < height && rj > 0) {
            if (layout[ri + 1][rj - 1] == floor) {
                ri++;
                rj--;
            } else if (layout[ri + 1][rj - 1] == empty) {
                sw = 1;
                rj = 0;
            }else if (layout[ri + 1][rj - 1] == occupied) {
                rj = -1;
            }
        }
        if (ri == height || rj == 0)
            sw = 1;

        //reset
        ri = i;
        rj = j;
        while (ri < height) {
            if (layout[ri + 1][rj] == floor) {
                ri++;
            } else if (layout[ri + 1][rj] == empty) {
                s = 1;
                ri = height;
            } else if (layout[ri + 1][rj] == occupied) {
                ri = height+1;
            }
        }
        if (ri == height)
            s = 1;

        //reset
        ri = i;
        rj = j;
        while (ri < height && rj < width) {
            if (layout[ri + 1][rj + 1] == floor) {
                ri++;
                rj++;
            } else if (layout[ri + 1][rj + 1] == empty) {
                se = 1;
                ri = height;
            } else if (layout[ri + 1][rj + 1] == occupied) {
                ri = height+1;
            }
        }
        if (ri == height || rj == width)
            se = 1;

        return (nw + n + ne + w + e + sw + s + se) == 8;
    }
}
