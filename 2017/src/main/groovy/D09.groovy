class D09 {

    def garbageOpen = '<'
    def garbageClose = '>'
    def ignore = '!'
    def groupOpen = '{'
    def groupClose = '}'
    int cpt = 0
    int score = 0
    int removed = 0

    void countGroup(String line) {
        int garbaging = 0
        int grouping = 0
        cpt = 0
        score = 0
        removed = 0

        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case ignore:
                    i++
                    break
                case garbageOpen:
                    if(garbaging>0)
                        removed ++
                    if(garbaging==0)
                        garbaging++
                    break
                case garbageClose:
                    garbaging--
                    if(garbaging>0)
                        removed ++
                    break
                case groupOpen:
                    if (garbaging==0) {
                        grouping++
                    }else
                        removed ++
                    break
                case groupClose:
                    if (garbaging==0 && grouping>0) {
                        grouping--
                        cpt++
                        score = score + grouping+ 1
                    }else{
                        removed++
                    }
                    break
                default:
                    if(garbaging>0)
                        removed ++
                    break
            }
        }
    }
}