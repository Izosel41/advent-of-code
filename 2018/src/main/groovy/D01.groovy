class D01 {

    int calibrate(List<String> steps) {
//	first implementation
		steps.inject(0){frequency, it -> it.toInteger()+frequency}
    }


    def calibrateUntil(List<String> steps) {
        Set memory = []
        int result = 0
        boolean found = false

        while (true) {
            for (int step in steps*.toInteger()) {
                result = result + step
                found = !memory.add(result)
                if (found)
                    return result
            }
        }
    }
}
