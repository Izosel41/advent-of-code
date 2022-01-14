class D11Test extends GroovyTestCase{
    D11 day = new D11()

    void testPowerLevel(){
        assert 4 == day.powerLevel(3,5,8)
        assert -5 == day.powerLevel(122,79,57)
        assert 0 == day.powerLevel(217,196,39)
        assert 4 == day.powerLevel(101,153,71)
        assert 4 == day.powerLevel(21,61, 42)

        assert 4 == day.powerLevel(33,45, 18)
        assert 4 == day.powerLevel(34,45, 18)
        assert 4 == day.powerLevel(35,45, 18)

        assert 3 == day.powerLevel(33,46, 18)
        assert 3 == day.powerLevel(34,46, 18)
        assert 4 == day.powerLevel(35,46, 18)

        assert 1 == day.powerLevel(33,47, 18)
        assert 2 == day.powerLevel(34,47, 18)
        assert 4 == day.powerLevel(35,47, 18)
    }

    void testBuildGrid(){
        def grid = day.buildGrid(50, 50,18)
        assert 4 == grid[33][45]
        assert 4 == grid[34][45]
        assert 4 == grid[35][45]

        assert 3 == grid[33][46]
        assert 3 == grid[34][46]
        assert 4 == grid[35][46]

        assert 1 == grid[33][47]
        assert 2 == grid[34][47]
        assert 4 == grid[35][47]

        grid = day.buildGrid(70, 70, 42)
        assert 4 == grid[21][61]
        assert 3 == grid[22][61]
        assert 3 == grid[23][61]

        assert 3 == grid[21][62]
        assert 3 == grid[22][62]
        assert 4 == grid[23][62]

        assert 3 == grid[21][63]
        assert 3 == grid[22][63]
        assert 4 == grid[23][63]
    }

    void testFindHighLevelSquare(){
        assert "33,45" == day.findHighLevelSquare(18)
        assert "21,61" == day.findHighLevelSquare(42)
    }

    void testOne(){
        println day.findHighLevelSquare(9221)
    }

    void testFindLargestSquare(){
        assert "90,269,16" == day.findMaxSquare(18)
       assert "232,251,12" == day.findMaxSquare(42)
    }

    void testSecond(){
        println day.findMaxSquare(9221)
    }
}
