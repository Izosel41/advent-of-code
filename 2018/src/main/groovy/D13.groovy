class D13 {
    def straight = ["|", "-"]
    def curves = ["/", "\\"]
    def intersection =["+"]
    def face = ["<", "^", ">"]

    Object move(List<String> strings) {
        null
    }

    class Cart{
        int turn = 0
        void turn(){
            switch (this.turn){
                case 0:
                    //turn left
                    turn++
                break;

                case 1:
                    //turn straight
                    turn++
                    break;

                case 2:
                    //turn right
                    turn = 0
                    break;
            }
        }

        void move(){
        }
    }*/
}
