class D05 {

    def react(String s) {
        List<Byte> poly = s.getBytes().toList()
        int i = 0
        while (i < poly.size() - 1) {
            if (32 == Math.abs(poly[i] - poly[i + 1])) {
                poly.remove(i)
                //as the first one is removed, remove the current
                poly.remove(i)

                if(i>1)
                    i--
                else
                    i=0
            } else {
                i++
            }
        }
        return new String((byte[]) poly.toArray())
    }

    int fullReact(String s) {
        // Caution: unique() changes the original collection, so
        // for the sample we invoke unique each time on a fresh new
        // list.
        List<Byte> units = new ArrayList<Byte>(s.toUpperCase().getBytes().toList())
        units = units.unique()

        return units.stream()
                .collect{it -> removeUnit(it, s) }
                //.collect{it -> s}
                .collect{it -> react(it)}
                .collect{it -> it.size()}
                .min()
    }

    String removeUnit(byte unit, String s) {
        def minuscule = new String((byte)(unit +32))
        def majuscule = new String(unit)
        def result = s.replaceAll(minuscule, '').replaceAll(majuscule, '')
        return result
    }
}