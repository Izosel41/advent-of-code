class D01 {

    public int findTwo(Integer[] expenses) {

        for(int i=0; i<expenses.length-1;i++){
            if(expenses[i]<2020){
                for(int j=0;j<expenses.length-2;j++) {
                    if (expenses[i] + expenses[j] == 2020)
                        return expenses[i] * expenses[j];
                }
            }
        }
        return -1;
    }


    public int findThree(Integer[] expenses) {
        for(int i=0; i<expenses.length-1;i++){
            if(expenses[i]<2020) {
                for (int j = 0; j < expenses.length - 2; j++) {
                    for (int k = 0; k < expenses.length - 3; k++) {
                        if (expenses[i] + expenses[j] + expenses[k] == 2020)
                            return (expenses[i] * expenses[j] * expenses[k]);
                    }
                }
            }
        }
        return -1;
    }
}
