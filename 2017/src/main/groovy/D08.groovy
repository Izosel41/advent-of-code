class D08 {

    def registry = [:]
    def maximum = 0

    def instruct(String line) {
        //split instruction from condition
        def steps = line.split("if")

        //check the condition
        def condition = steps[1]
        def prop = condition.split(" ")

        //if registry absent, default value = 0
        steps[1] = steps[1].replace(prop[1], registry.get(prop[1], 0).toString())

        def evalCond = "${steps[1]}"
        //apply the instruction
        if(Eval.me(evalCond)){
            def instrs = steps[0].split(" ")
            def reg = instrs[0]

            if(!registry.containsKey(reg))
                registry.put(reg, 0)

            def value = registry[reg]
            if(instrs[1] == "inc")
                value += Integer.valueOf(instrs[2])
            else
                value -= Integer.valueOf(instrs[2])
            registry.put(reg, value)

            if(maximum < registry.max{it.value}.value )
                maximum = registry.max{it.value}.value
        }

        return registry
    }
}