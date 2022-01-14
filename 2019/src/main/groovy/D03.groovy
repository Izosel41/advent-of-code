import org.codehaus.groovy.syntax.Numbers

class D03 {

    int crossing(String wire1, String wire2) {

        def w1 = runWire(wire1)
        def w2 = runWire(wire2)

        // use the copy constructor
        Set<Coord> intersection = new HashSet<Coord>(w1)
        intersection.retainAll(w2)

        findNearest(intersection)
    }


    Set runWire(String cmd) {
        int x = 0
        int y = 0
        int step = 0
        Set grid = new HashSet()
        cmd.tokenize(",").forEach({ instruction ->
            def dir = instruction.charAt(0)
            def move = Integer.parseInt(instruction.substring(1)).intValue()
            switch (dir) {
                case "U":
                    for (int i = 0; i < move; i++) {
                        y++
                        step ++
                        grid.add(new Coord(x, y, step))
                    }
                    break
                case "R":
                    for (int i = 0; i < move; i++) {
                        x++
                        step ++
                        grid.add(new Coord(x, y, step))
                    }
                    break
                case "D":
                    for (int i = 0; i < move; i++) {
                        y--
                        step ++
                        grid.add(new Coord(x, y, step))
                    }
                    break
                case "L":
                    for (int i = 0; i < move; i++) {
                        x--
                        step ++
                        grid.add(new Coord(x, y, step))
                    }
                    break
            }
        }
        )
        grid
    }

    int findNearest(HashSet<Coord> coords) {
        if (coords.size() == 1)
            return distance(coords[0])
        else
            return coords.stream().mapToInt({ e -> distance(e) }).min().getAsInt()
    }

    int distance(Coord coord) {
        Math.abs(coord.x) + Math.abs(coord.y)
    }

    def int fastestCrossing(String wire1, String wire2) {
        def w1 = runWire(wire1)
        def w2 = runWire(wire2)

        // use the copy constructor
        Set<Coord> intersection = new HashSet<Coord>(w1)
        intersection.retainAll(w2)

        intersection.stream().mapToInt({ e -> e.step + w2.find{it.equals(e)}.step }).min().getAsInt()
    }
}
