class D12Test extends GroovyTestCase{
    D12 day = new D12()
//
//    void testGrow(){
//        List<String> input = Util.extractLines("12_1.txt")
//        String init = "#..#.#..##......###...###"
//        def result = day.growGeneration(init, input, 1)
//        assert "..#...#....#.....#..#..#..#.." == result
//    }

    void testGrowGeneration(){
        List<String> input = Util.extractLines("12_1.txt")
        String init = "#..#.#..##......###...###"
        def pots = []
        pots = init.chars.collect {it=="."?0:1}.toArray()

        Map dico = day.buildDico(input)

        def result = day.growGeneration(pots, dico,20)
        assert 325 == day.calc(result)

    }

    void testOne(){
        List<String> input = Util.extractLines("12.txt")
        String init = "#.#####.#.#.####.####.#.#...#.......##..##.#.#.#.###..#.....#.####..#.#######.#....####.#....##....#"
        def pots = []
        pots = init.chars.collect {it=="."?0:1}.toArray()

        Map dico = day.buildDico(input)

        def result = day.growGeneration(pots, dico, 20)
        println day.calc(result)
//        println result.findAll{it.value == "#"}.keySet().sum()
    }

    void testTwo(){
        List<String> input = Util.extractLines("12.txt")
        String init = "#.#####.#.#.####.####.#.#...#.......##..##.#.#.#.###..#.....#.####..#.#######.#....####.#....##....#"
//        def gen = 1
//        def result = day.growGeneration(init, input, gen)
//        println day.calc(result)
//        gen = gen * 10
//        result =  day.growGeneration(init, input, gen)
//        println day.calc(result)
//        gen = gen * 10
//        result = day.growGeneration(init, input, gen)
//        println day.calc(result)
//        gen = gen * 10
//        result = day.growGeneration(init, input, gen)
//        println day.calc(result)

        def pots = []
        pots = init.chars.collect {it=="."?0:1}.toArray()

        Map dico = day.buildDico(input)

        def previousPots = day.growGeneration(pots, dico, 1000)
        def previous = day.calc(previousPots)
        def current = day.calc(day.growGeneration(previousPots, dico, 1))

        println (previous + (current - previous) * (50000000000 - 1000))
    }
}
