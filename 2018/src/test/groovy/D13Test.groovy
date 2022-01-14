class D13Test extends GroovyTestCase{
    D13 day = new D13()

    void testMoveOnLine(){
        List<String> input = Util.extractLines("13_1.txt")
        def result = day.move(input)
        println result
    }
//    void testOne(){
//        List<String> input = Util.extractLines("12.txt")
//        String init = "#.#####.#.#.####.####.#.#...#.......##..##.#.#.#.###..#.....#.####..#.#######.#....####.#....##....#"
//        def result = day.growGeneration(init.chars, input, 20)
//        println result
//        println result.findAll{it.value == "#"}.keySet().sum()
//        //3494
//        // . . # # # . . # . # . # . # . # . # . # . # . # . # . # . # . # . # . # . . . . . . # . # . # # . # # . # . # . . # . # . # . # . # . # # . # . # # . # . . # . # . # . # . # . # . # . # . # . # . # . # . # . # . # . .
//        // . . # # # . . # . # . # . # . # . # . # . # . # . # . # . # . # . # . # . . . . . . # . # . # # . # # . # . # . . # . # . # . # . # . # # . # . # # . # . . # . # . # . # . # . # . # . # . # . # . # . # . # . # . # . .
//    }
//
//    void testTwo(){
//        List<String> input = Util.extractLines("12.txt")
//        String init = "#.#####.#.#.####.####.#.#...#.......##..##.#.#.#.###..#.....#.####..#.#######.#....####.#....##....#"
//        def result = day.growGeneration(init.chars, input, 50000000000)
//        println result.findAll{it.value == "#"}.keySet().sum()
//    }
}
