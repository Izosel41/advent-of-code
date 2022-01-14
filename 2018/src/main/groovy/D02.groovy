class D02 {

    LinkedHashMap count(String box) {
        def occ = [:]
        //count each occurrence
        def registry = box.chars().collect().countBy {it}

        //#2
        def val = registry.find{it.value==2}
        occ.put(2,val==null?0:val.value)
        //#3
        val = registry.find{it.value==3}
        occ.put(3,val==null?0:val.value)
        occ
    }

    int checksum(List<String> boxes) {
        int two = 0
        int three = 0
        for(box in boxes) {
            def val = count(box)
            if(val.get(2)>0)
                two++
            if(val.get(3))
                three++
        }

        two * three
    }

    String findCommon(List<String> boxes) {
        for (int i=0; i<boxes.size()-1; i++){
            def boxRef = boxes[i].chars
            for(int j=i+1; j<boxes.size()-1;j++){
                def boxCandidate = boxes[j].chars
                int diff = 0
                //which letter differs
                def idx = 0

                for(int k=0; k<boxRef.size()&&diff<3; k++){
                    if(boxRef[k] != boxCandidate[k]){
                        diff++
                        idx = k
                    }
                }

                if (diff<2)
                    return (boxRef[0..idx-1] + boxRef[idx+1..boxRef.size()-1]).join()

            }
        }
        return "should have return something else..."
    }
}
