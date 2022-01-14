class D12 {
    int cursor = 0

    def extendMap(def initial) {
        def pots = []
        if(initial[0..4].any {it==1}){
            cursor += 4
            4.times {pots.add(0)}
        }
        pots.addAll(initial)
        if(initial[initial.size()-4..initial.size()-1].any {it==1}){
            4.times {pots.add(0)}
        }
        pots
    }

    Map buildDico(List<String> notes) {
        Map dico = [:]
        for (n in notes) {
            List<String> spread = n.tokenize("=>")*.trim()
            String pattern = spread[0]
            char result = spread[1].chars[0]
            dico << [(pattern): result]
        }
        dico
    }

    def grow(def pots, Map dico) {
        def nextGen = pots.clone()

        for (int i = 0; i < pots.size() - 4; i++) {
            def plant = pots[i..i+4].join()
            if (dico.containsKey(plant)) {
                nextGen[(i + 2)] = (int)dico.get(plant)
            }
        }
        nextGen
    }

    def growGeneration(pots, dico, gen) {

        for (def i = 0; i < gen; i++) {
            pots = extendMap(pots)
            pots = grow(pots, dico)
        }
        pots
    }

    int calc(pots) {

        int res = 0
        //calc
        for (int i = 0; i < pots.size(); i++) {
            if (pots[i] == 1)
                res = res + i-cursor
        }
        res
    }
}
