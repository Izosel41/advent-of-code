class D11 {

    //thx https://www.redblobgames.com/grids/hexagons/
    def stepAway(String path) {
        //an hexagonal grid can be mapped by x,y,z coordinates
        def x = 0
        def y = 0
        def z = 0
        int d = 0

        for (step in path.tokenize(",")) {
            switch (step) {
                case "ne":
                    x += 1
                    z -= 1
                    break
                case "n":
                    y += 1
                    z -= 1
                    break
                case "nw":
                    x -= 1
                    y += 1
                    break
                case "sw":
                    x -= 1
                    z += 1
                    break
                case "s":
                    y -= 1
                    z += 1
                    break
                case "se":
                    x++
                    y--
                    break
            }
            //keep the max distance
            d = Math.max(d, distance(x, y, z))
        }
        println x + "," + y + "," + z
        println "Max :" + d
        return distance(x, y, z)
    }

    // max of the three coordinates is the distance
    int distance(x, y, z){
        return (Math.abs(x) + Math.abs(y) + Math.abs(z))/2
    }

}
