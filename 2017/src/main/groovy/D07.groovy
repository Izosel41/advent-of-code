class D07 {

    boolean found = false

    Prog findRoot(Collection<String> lines) {
        //parse and add without links the progs if possible
        List<Prog> progs = new ArrayList<Prog>()

        //first the leaves
        for (line in lines.findAll { !it.contains("->") }) {
            String[] definition = line.split(" ")
            String name = definition[0]
            int weight = Integer.parseInt(definition[1].substring(1, definition[1].size() - 1))
            progs.add(new Leaf(name, weight))
        }

        //then create the nodes
        for (line in lines.findAll { it.contains("->") }) {
            String[] definition = line.split(" ")
            String name = definition[0]
            int weight = Integer.parseInt(definition[1].substring(1, definition[1].size() - 1))
            Node p = new Node(name, weight)
            def children = definition.drop(3)*.replace(",", "")

            for (child in children) {
                //the child is already created -> attach it
                def presentProg = progs.find { it.getName() == child && it instanceof Leaf }
                if (presentProg != null) {
                    p.add(presentProg)
                    progs.remove(presentProg)
                } else {
                    def leaf = new Leaf(child, -1)
                    p.add(leaf)
                }
            }
            progs.add(p)
        }

        //attach the nodes between them
        while (progs.size() > 1) {
            //find a program with all its child: it should be attached
            Node child = progs.find { !((Node) it).children.find { it.getWeight() == -1 } }
            //find its parent
            Node parent = progs.find { ((Node) it).getChildren().findAll { it.getName() == child.name } }
            if (parent != null) {
                Prog rm = parent.children.find { it.name == child.name }
                parent.children.remove(rm)
                parent.add(child)
                progs.remove(child)
            }
        }
        return progs.get(0)
    }

    Prog findBalancedWeight(Prog p) {
        Node root = (Node) p
        List<Node> towers = new ArrayList<Node>()
        for (Prog prog in root.children) {
            if (prog instanceof Node) {
                def pCalc = findBalancedWeight(prog)
                if (found)
                    return pCalc
                else
                    towers.add(pCalc)
            } else
                towers.add(prog)
        }
        int avgWeight = towers*.calcWeight().sum() / towers.size()

        if (towers.count { it.calcWeight() == avgWeight } == towers.size()) {
            //balanced
            return root
        } else {
            found = true
            // one of them is unbalanced
            if (towers.find { it.weight == towers*.calcWeight().min() } == 1) {
                def min = towers.find { it.calcWeight() == towers*.calcWeight().min() }
                return new Leaf(min.name, min.weight + towers*.calcWeight().max() - towers*.calcWeight().min())
            } else {
                def max = towers.find { it.calcWeight() == towers*.calcWeight().max() }
                return new Leaf(max.name, max.weight + towers*.calcWeight().min() - towers*.calcWeight().max())
            }
        }
    }
}

//composite pattern
interface Prog {
    String getName()

    int calcWeight()

    int getWeight()
}

class Node implements Prog {
    String name
    int weight
    List<Prog> children

    Node(String name, int weight) {
        this.name = name
        this.weight = weight
        this.children = new ArrayList<Prog>()
    }

    void add(Prog p) {
        this.children.add(p)
    }

    List<Prog> getChildren() {
        return this.children
    }

    int calcWeight() {
        return this.weight + this.children*.calcWeight().sum()
    }

    @Override
    String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", children=" + children +
                '}'
    }
}

class Leaf implements Prog {
    String name
    int weight

    Leaf(String name, int weight) {
        this.name = name
        this.weight = weight
    }

    int calcWeight() {
        return this.weight
    }

    @Override
    String toString() {
        return "Leaf{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}'
    }
}