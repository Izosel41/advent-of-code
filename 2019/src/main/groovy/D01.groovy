class D01 {

    int fuel(List<String> masses) {
        masses*.toInteger().inject(0) { total, arg -> total += calcFuel(arg) }
    }

    private int calcFuel(mass) {
        int division = mass.intdiv(3)
        division < 2 ? 0 : division - 2
    }

    def cal(int m, def accu = 0) {
        if (m < 3)
            return accu
        cal.trampoline(calcFuel(f), m + accu)
    }

    int calculateExtrafuel(int mass) {
        int fuelForMass = calcFuel(mass)

        def cal
        cal = { int m, def accu = 0 ->
            if (m < 1)
                return accu
            cal.trampoline(calcFuel(m), m + accu)
        }
        cal = cal.trampoline()

        cal(fuelForMass)
    }
}