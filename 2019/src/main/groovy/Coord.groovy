class Coord {
    int x
    int y
    int step

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Coord coord = (Coord) o

        if (x != coord.x) return false
        if (y != coord.y) return false

        return true
    }

    int hashCode() {
        int result
        result = x
        result = 31 * result + y
        return result
    }

    Coord(int x, int y) {
        this.x = x
        this.y = y
    }

    Coord(int x, int y, int step) {
        this.x = x
        this.y = y
        this.step = step
    }
}
