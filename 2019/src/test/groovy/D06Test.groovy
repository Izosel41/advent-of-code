import java.util.stream.Collectors

class D06Test extends GroovyTestCase {

    D06 day = new D06()

    void testOrbits() {
        List<Planet> planets = day.createOrbits(Util.extractLines("61.txt"))

        assert 3 == day.calculateOrbits(planets, planets.find({ it.name == "D" }))
        assert 7 == day.calculateOrbits(planets, planets.find({ it.name == "L" }))

        assert 42 == planets.stream()
                .mapToInt({ e -> day.calculateOrbits(planets, e) })
                .sum()
    }

    void testFirst() {
        List<Planet> planets = day.createOrbits(Util.extractLines("6.txt"))
        println planets.stream()
                .mapToInt({ e -> day.calculateOrbits(planets, e) })
                .sum()
    }

    void testComputePath() {
        List<Planet> planets = day.createOrbits(Util.extractLines("62.txt"))

        List<String> youToCom = day.computePath(planets, planets.find({ it.name == "YOU" }))
        List<String> sanToCom = day.computePath(planets, planets.find({ it.name == "SAN" }))
        String common = null
        int i = 0
        while (common == null) {
            def planet = youToCom[i]
            if (sanToCom.contains(planet))
                common = planet
            else
                i++
        }
        println common
        def a = i
        def b = sanToCom.findIndexOf { it == common }

        assert 4 == a + b
    }

    void testSecond() {
        List<Planet> planets = day.createOrbits(Util.extractLines("6.txt"))

        List<String> youToCom = day.computePath(planets, planets.find({ it.name == "YOU" }))
        List<String> sanToCom = day.computePath(planets, planets.find({ it.name == "SAN" }))
        String common = null
        int i = 0
        while (common == null) {
            def planet = youToCom[i]
            if (sanToCom.contains(planet))
                common = planet
            else
                i++
        }
        def a = i
        def b = sanToCom.findIndexOf { it == common }

        println a + b
    }
}