public class Instruction {
    int operation
    int[] modes

    Instruction(Integer ins) {
        if (ins < 10) {
            this.operation = ins
            this.modes = [0, 0]
        } else {
            def instruction = ins.toString()
            this.operation = Integer.parseInt(instruction.substring(instruction.length() - 2, instruction.length()))
            char[] a = instruction.substring(0, instruction.length() - 2).reverse().chars
            List<Integer> m = new ArrayList<>()
            for (char c : a) {
                m.add(Character.getNumericValue(c))
            }
            if (m.size() == 1)
                m.add(0)
            this.modes = m
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "operation=" + operation +
                ", modes=" + Arrays.toString(modes) +
                '}';
    }
}