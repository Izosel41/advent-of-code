class D02 {

    int intcode( List<Integer> registry) {
        int cur = 0
        while (99 != registry[cur]) {

            switch (registry[cur]) {
                case 1:
                    registry[registry[cur + 3]] = registry[registry[cur + 1]] + registry[registry[cur + 2]]
                    break
                case 2:
                    registry[registry[cur + 3]] = registry[registry[cur + 1]] * registry[registry[cur + 2]]
                    break
                case 99:
                    return registry[0]
                    break
                default:
                    return -99
            }
            cur = cur + 4
        }
        registry[0]
    }
}
