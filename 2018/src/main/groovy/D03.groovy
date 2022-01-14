class D03 {

    int count(List<String> claims) {
        int[][] square = createClaims(claims)
        square.collect().flatten().count{it>1}
    }

    int[][] createClaims(List<String> claims) {
        def square = new int[1000][1000]

        for (claim in claims) {
            String[] definition = claim.tokenize()

            def x = definition[2].tokenize(",").get(0).toInteger()
            def y = definition[2].tokenize(",").get(1).replace(":", "").toInteger()

            def width = definition[3].tokenize("x").get(0).toInteger()
            def length = definition[3].tokenize("x").get(1).toInteger()

            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + length; j++) {
                    square[i][j] = ++square[i][j]
                }
            }
        }
        square
    }

    String findLoneClaim(List<String>claims) {
        int[][] square = createClaims(claims)

        for (claim in claims) {
            String[] definition = claim.tokenize()

            def x = definition[2].tokenize(",").get(0).toInteger()
            def y = definition[2].tokenize(",").get(1).replace(":", "").toInteger()

            def width = definition[3].tokenize("x").get(0).toInteger()
            def length = definition[3].tokenize("x").get(1).toInteger()
            boolean overClaimed = false
            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + length; j++) {
                    if(1 != square[i][j])
                        overClaimed = true
                }
            }
            if (!overClaimed)
                return definition[0]
        }
    }
}