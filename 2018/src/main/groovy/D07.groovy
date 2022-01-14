class D07 {

    String buildInst(List<String> notices) {
        List<Step> registry = buildRegistry(notices)

        StringBuilder result = new StringBuilder("")

        while (!registry.every { it.done }) {
            def steps = registry.findAll { !it.done }.sort { it.name }

            for (int i = 0; i < steps.size(); i++) {
                if (steps[i].previousSteps.every { it.done }) {
                    steps[i].done = true
                    result.append(steps[i].name)
                    i = steps.size()
                } else {
                    print "."
                }
            }
        }
        return result
    }

    private List<Step> buildRegistry(List<String> notices) {
        List<Step> registry = []

        //build different steps alone
        for (notice in notices) {
            def steps = notice.tokenize()
            if (!registry.find { it.name == steps[1] }) {
                Step st = new Step(steps[1])
                registry << st
            }
            if (!registry.find { it.name == steps[7] }) {
                Step st = new Step(steps[7])
                registry << st
            }
        }

        //link them
        for (notice in notices) {
            def steps = notice.tokenize()
            Step parent = registry.find { it.name == steps[1] }
            Step child = registry.find { it.name == steps[7] }
            parent.nextSteps.add(child)
            child.previousSteps.add(parent)
        }
        registry
    }

    int execute(List<String> notices, int workers, int time) {
        List<Step> registry = buildRegistry(notices)

        int cpt = 0
        while (!registry.every { it.done }) {
            //first free the workers!
            registry.findAll { !it.done && it.worker?.timeoff == cpt }.forEach { it -> it.done = true; it.worker = null; println it.name+" done at "+cpt }
            def stepsToDo = registry.findAll { !it.done }.sort { it.name }


            for (int i = 0; i < stepsToDo.size(); i++) {
                if (stepsToDo.count { it.worker } < workers) {
                    //ready to work on
                    if (stepsToDo[i].previousSteps.every { it.done }) {
                        if (stepsToDo[i].worker == null) {
                            Worker w = new Worker()
                            w.timeoff = cpt + time + (stepsToDo[i].name.getBytes()[0] - 65) +1
                            stepsToDo[i].worker = w
                        }
                    }
                }
            }
            //case where the task is done in 1 cpt
            registry.findAll { !it.done && it.worker?.timeoff == cpt }.forEach { it -> it.done = true; it.worker = null }
            cpt++
        }

        cpt-1
    }

    class Step {
        String name
        List<Step> previousSteps
        List<Step> nextSteps
        Boolean done
        Worker worker

        Step(String name) {
            this.name = name
            this.nextSteps = new ArrayList<Step>()
            this.previousSteps = new ArrayList<Step>()
            this.done = false
            this.worker = null
        }

        @Override
        String toString() {
            return this.name
        }
    }

    class Worker {
        Step task
        int timeoff
    }
}
