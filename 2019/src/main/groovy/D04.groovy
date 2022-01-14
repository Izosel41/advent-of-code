class D04 {

    Boolean findPassword(int password){
       def p = password.toInteger().toString()
        adjacent(p.chars) && increase(p.chars)
    }

    boolean adjacent(char[] chars) {
        boolean res = false
        for(int i= 0; i<chars.size()-1 ; i++){
            if(chars[i]==chars[i+1])
                res = true
        }
        res
    }

    boolean increase(char[] chars) {
        boolean res = true
        for(int i= 0; i<chars.size()-1 ; i++){
            if(chars[i]>chars[i+1])
                res = false
        }
        res
    }

    boolean adjacent2(char[] chars) {
        boolean res = false
        chars = 'a' + chars + 'a'
        for (int i = 1; i < chars.size() - 2; i++) {
            if ((chars[i] == chars[i + 1]) && (chars[i] != chars[i + 2]) && (chars[i - 1] != chars[i]))
                res = true
        }
        res
    }

    Boolean findPassword2(int password){
        def p = password.toInteger().toString()
        adjacent2(p.chars) && increase(p.chars)
    }
}
