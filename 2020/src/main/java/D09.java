import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class D09 {

    public Long findWeakness(Long[] input, int preamble) {
        for(int i=0;i<input.length;i++){
            Long next = input[preamble+i];

            if(!validate(input, preamble, i, next))
                return next;
        }
        return -1L;
    }

    private boolean validate(Long[] input, int preamble, int i, Long next) {
        for(int j = i; j< preamble + i; j++) {
            for(int k = i +1; k< preamble + i; k++) {
                if(input[j]+input[k]==next)
                    return true;
            }
        }
        return false;
    }

    public Long findContiguous(Long[] input, int preamble) {
        Long weakness = null;
        int i = 0;
        while(weakness==null){
            Long next = input[preamble+i];

            if(!validate(input, preamble, i, next)) {
                weakness = next;
            }
            i++;
        }
        //look for min and min between i and i-preamble
        for(int j = 0; j< i; j++) {
            for(int k = j +1; k< i; k++) {
                Long[]range = Arrays.copyOfRange(input,j,k);
                long temp = Arrays.stream(range).collect(Collectors.summingLong(Long::valueOf));
                //stop the contiguous
                if(temp>weakness)
                    k=i;
                if(temp == weakness) {
                    //range
                    Long min = Arrays.stream(range).min(Comparator.comparing(Long::valueOf)).get();
                    Long max = Arrays.stream(range).max(Comparator.comparing(Long::valueOf)).get();
                    return min+max;
                }
            }
        }
        return -1L;
    }

    private Long addRange(Long[] input, int preamble, int i, Long next) {
        for(int j = i; j< preamble + i; j++) {
            for(int k = j +1; k< preamble + i; k++) {
                if(input[j]+input[k]==next) {
                    return null;
                }
            }
        }
        return null;
    }
}
