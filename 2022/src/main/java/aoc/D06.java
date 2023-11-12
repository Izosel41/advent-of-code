package aoc;

import java.util.HashSet;
import java.util.Set;

class D06 {

    public int one(String puzzle, int screen) {
        String[] chars = puzzle.split("");
        int res =0;
        int i = screen-1;
        while(res==0){

            Set<String> dic = new HashSet<>();
            for(int j=0; j<screen; j++) {
                dic.add(chars[i-j]);
            }
            if(dic.size()==screen)
                res = i+1;
            else
                i++;
        }
        return res;
    }

}
