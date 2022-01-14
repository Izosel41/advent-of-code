class D10 {
    def pos = 0
    def skip = 0

    //TODO linkedlist
    int[] pinch(int[] circle, arcs, run) {
        for (int round = 0; round < run; round++) {
            //println " - round = "+round
            for (arc in arcs) {
                //println "arc = " +arc
                //index to reverse
                def index = []

                //if the circle loops
                if (pos + arc - 1 >= circle.size()) {
                    //from pos to end
                    index = pos..(circle.size() - 1)
                    //from start to
                    index = index.plus(0..(pos + arc - circle.size() - 1))
                } else {
                    index = pos..(pos + arc - 1)
                }
                //value to reverse
                def oldValues = []
                for (idx in index) {
                    oldValues << circle[idx]
                }
                oldValues = oldValues.reverse()

                //reverse
                int i = 0
                for (idx in index) {
                    circle[idx] = oldValues[i]
                    i++
                }

                // Move the current position forward by that length plus the skip size.
                pos = pos + arc + skip
                while (pos >= circle.size()) {
                    pos = pos - circle.size()
                }
                // Increase the skip size by one.
                skip++
            }
        }

        circle
    }

    def check(int[] circle) {
        return circle[0] * circle[1]
    }

    def knotHash(String input) {
        def arcs = toAscii(input)
        //add the suffix
        arcs << [17, 31, 73, 47, 23]
        println arcs
        int[] circle = 0..255
        def sparseHash = pinch(circle, arcs.flatten(), 64)
        def denseHash = []
        for (int i = 0; i < circle.size(); i = i + 16) {
            denseHash << dense(sparseHash[i..i + 15])
        }
        toHex(denseHash)
    }

    def toAscii(String input) {
        def result = []
        for (c in input.getChars())
            result << (c as int)

        return result
    }

    def dense(input) {
        return input.inject(0) { result, a -> result ^ a }
    }

    def toHex(ints) {
        ((byte[]) ints).encodeHex().toString()
    }
}