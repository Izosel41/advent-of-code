class D11 {

    String findMaxSquare(int gridSerialNumber){

        def max = 0
        def result = ""
        Integer[][] grid = buildGrid(300,300,gridSerialNumber)

        for(int i in 1..27){
            def s = findHighLevelSquare(grid, i)
            println i +" "+ s

            if(s.keySet()[0] > max){
                max = s.keySet()[0]
                result = s.get(max)
            }
        }

        return result
    }

    def findHighLevelSquare(Integer[][] grid, int square=3){
        int xMax =0
        int yMax =0
        def max =0

        for(int x =1; x<301-square; x++){
            for(int y =1; y<301-square; y++){

                def powerLvl = 0
                for (int xOff = 0; xOff<square; xOff++) {
                    for (int yOff = 0; yOff<square; yOff++) {
                        powerLvl = powerLvl + grid[x + xOff][y + yOff]
                    }
                }
                //println powerLvl + " " +max
                if(powerLvl>max){
                    xMax = x
                    yMax = y
                    max = powerLvl
                }
            }
        }
        return [(max) : xMax+","+yMax+","+square]
    }

    Integer[][] buildGrid(int xLength, int yLength, int gridSerialNumber) {
        Integer[][] grid = new Integer[xLength+1][yLength+1]

        for (int x = 1; x < xLength+1; x++) {
            for (int y = 1; y < yLength+1; y++) {
                grid[x][y] = powerLevel(x, y, gridSerialNumber)
            }
        }
        grid
    }

    int powerLevel(int x, int y, int gridSerialNumber) {
        int rackId = x + 10
        int powerLvl = (y * rackId + gridSerialNumber) * rackId
        def hundred = Integer.toString(powerLvl)
        powerLvl = Integer.parseInt(hundred.substring(hundred.size() - 3, hundred.size() - 2))
        powerLvl - 5
    }
}
