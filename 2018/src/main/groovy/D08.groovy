class D08 {

    List<Integer> data = null
    HashMap<Integer, Integer> gMeta = [:]
    int gValue =0

    int sumMeta(String license) {
        data = license.tokenize()*.toInteger()
        Node init = new Node(0, 0, 0, null)
        Node root = buildNodes(init)

        return gMeta.values().sum()
    }

    int rootValue(String license){
        data = license.tokenize()*.toInteger()
        Node init = new Node(0, 0, 0, null)
        Node root = buildNodes(init)
        root.value
    }

    private Node buildNodes(Node root) {
        int childNum = data[root.idx + 0]
        int metaNum = data[root.idx + 1]
        //println root.idx + ": which has " + childNum + " child nodes and " + metaNum + " metadata entries "

        if (childNum == 0) {
            int meta = data[root.idx + 2 .. root.idx + metaNum + 1 ].sum()
            gMeta << [(root.idx):meta]
            return new Node(root.idx + metaNum + 2, meta, meta , null)
        } else {
            root.idx = root.idx + 2
            Map<Integer, Integer> values = [:]
            for (int i = 0; i < childNum; i++) {
                Node child = buildNodes(new Node(root.idx, root.meta,0,null))
                root.idx = child.idx
                root.children<< child
                values.put(i, child.value)
            }

            //compute value of this root
            int value = 0
            for(m in data[root.idx.. root.idx+ metaNum-1]){
                def v = values.find {it.key+1 == m}

                if(! Objects.isNull(v))
                    value = value + v.value
            }
            gMeta << [(root.idx):data[root.idx.. root.idx+ metaNum-1].sum()]

            return new Node(root.idx + metaNum, data[root.idx.. root.idx+ metaNum-1].sum(), value , root.children)
        }
    }

    class Node {
        int meta
        int idx
        int value
        List<Node> children

        Node(int idx, int meta, int value, List<Node> children) {
            this.meta = meta
            this.idx = idx
            this.value = value

            this.children = new ArrayList<Node>()
            if(children!=null)
                this.children.addAll(children)
        }
    }
}
