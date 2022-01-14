import java.util.stream.Collectors

class D08Test extends GroovyTestCase {

    D08 day = new D08()

    void testCreateLayers() {
        List<List<List<Integer>>> layers = day.createLayers("123456789012", 3, 2)
        assert 2 == layers[0].size()

        assert [1, 2, 3] == layers[0][0]

        assert [4, 5, 6] == layers[0][1]

        assert 2 == layers[1].size()
        assert [7, 8, 9] == layers[1][0]

        assert [0, 1, 2] == layers[1][1]
    }

    void test1() {
        List<List<List<Integer>>> layers = day.createLayers(Util.extractLines("8.txt").get(0), 25, 6)

        Long min = layers
                .stream()
                .map({
                    layer -> new HashMap(
                        layer.stream().mapToLong({
                            pixels ->
                                pixels.stream()
                                        .filter({ pixel -> pixel == 0 })
                                        .count()
                        }).sum(), layer)
                }).collect(Collectors.toMap())
    
        List<Integer> layer = layers
                .stream()
                .filter({
                    it -> min ==
                        it.stream()
                                .mapToLong({
                                    pixels ->
                                       pixels.stream()
                                                .filter({ pixel -> pixel == 0 })
                                                .count()
                                }).sum()
                }).findFirst().get()

        println "layer : " + layer

        def one = layer.stream().mapToLong({
            pixels ->
                pixels.stream()
                        .filter({ pixel -> pixel == 1 })
                        .count()
        }).sum()

        def two = layer.stream() .mapToLong({
            pixels ->
                pixels.stream()
                        .filter({ pixel -> pixel == 2 })
                        .count()
        }).sum()

        println one
        println two
        println one * two
    }
}
