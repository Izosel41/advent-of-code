class D12 {

    def buildRegistry(List<String> pipes){
        Map<String, String[]> registry = new HashMap<>()
        // first build the keys and add the values without recursive
        for (String pipe in pipes){
            String args = pipe.tokenize("<->")
            String left = args[0]
            String[] rights = args[1].tokenize(",")

            registry.put(left,rights)
        }
        return registry
    }

    def programConnectedTo(String programRoot, Map<String, String[]>  registry) {
        def programConnnected = []
        def notConnected= []

        //[ [0, [1, 2, 3]] , [1,[2,3,4]] ]

        def root = registry.get(programRoot)

        if(root.contains(programRoot)){
            programConnnected.add(programRoot)
        }else{
            //explore from prog
            for(program in root){
                if(programConnnected.find{it==program} != null && notConnected.find{it==program} == null){
                    String[] pipe1 = registry.get(program)
                    if(pipe1.find{it==programRoot})
                        programConnnected.add(program)
                    else {
                        //recursively
                        for(p2 in pipe1){

                        }
                    }
                }



            }
        }

    }
}