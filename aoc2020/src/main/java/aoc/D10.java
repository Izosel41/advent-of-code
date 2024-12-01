package aoc;

import java.util.List;

public class D10 {

    public Integer jolt(List<Integer> input) {
        int one = 0;
        int three = 0;
        int adapter = 0;
        input.sort(Integer::compareTo);
        for(int i=0;i<input.size();i++){
            if(input.get(i).intValue()-adapter==1){
                one++;
                adapter++;
            }else if(input.get(i).intValue()-adapter==2){

                adapter = adapter+2;
            } else if(input.get(i).intValue()-adapter==3){
                three++;
                adapter = adapter+3;
            }
        }
        //last adapter add three
        three++;
        return one * three;
    }
}
