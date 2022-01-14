import java.lang.reflect.Array

class D08 {

    List<List<List<Integer>>> createLayers(String data, int wide, int tall) {
        List<List<List<Integer>>> layers = new ArrayList()

        for (int i = 0; i * (wide * layers.size()) < data.size(); i++) {
            List<List<Integer>> layer = new ArrayList()
            for (int j = 0; j < tall; j++) {
                String subStr = data.substring((i + j + layers.size()) * wide, (i + j + layers.size() + 1) * wide)
                List<Integer> pixels = new ArrayList<Integer>()
                for (int k = 0; k < subStr.size(); k++) {
                    pixels.add(new Integer(subStr.substring(k, k + 1)))
                }
                layer.add(pixels)
            }
            layers.add(layer)
        }
        layers
    }
}