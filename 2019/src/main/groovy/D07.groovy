class D07 {

    public Integer thruster(def phases, int inputSignal, Integer[] program) {
        IntCode code = new IntCode()
        for (int i = 0; i < phases.size(); i++) {
            //    println "phase" + phases[i]
            println "input " + inputSignal
            code.io.add(phases[i])
            code.io.add(inputSignal)
            code.run(program)
            inputSignal = code.io.removeFirst()
        }
        //   println inputSignal
        inputSignal
    }

    public Integer feedbackLoop(def phases, int inputSignal, Integer[] program) {
        def result = 0
        while (result != 99) {
            inputSignal = result
            result = thruster(phases, inputSignal, program)
            println result
        }
        inputSignal
    }
}
