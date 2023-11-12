package aoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class D07 {

    public Long one(List<String> puzzleTest) {

        F root = buildRoot(puzzleTest);
        return sizeRoot(root, 0);
    }

    private long sizeRoot(F f, long acc) {
        //folder
        if (f.getSize() == 0) {
            for (F child : f.getChildren().values()) {
                acc = sizeRoot(child, acc);
            }
            long s = f.getChildren().values().stream().mapToLong(F::getSize).sum();
            f.setSize(s);
            if (s < 100000)
                acc = acc + s;
        }
        return acc;
    }

    private F buildRoot(List<String> puzzleTest) {
        F root = new F(0, "root", null);
        F cur = root;

        for (String cmd : puzzleTest) {
            if (cmd.startsWith("$ cd ")) {
                String target = cmd.substring(5);
                cur = switch (target) {
                    case "/" -> root;
                    case ".." -> cur.father;
                    default -> cur.getChildren().get(target);
                };
            } else if (cmd.startsWith("dir ")) {
                String name = cmd.substring(4);
                F d = new F(0, cmd.substring(4), cur);
                cur.getChildren().put(name, d);
            } else if (cmd.startsWith("$ ls")) {
                // do nothing
            } else {
                String[] file = cmd.split(" ");
                F f = new F(Long.parseLong(file[0]), file[1], cur);
                cur.getChildren().put(file[1], f);
            }
        }
        return root;
    }

    public Long two(List<String> puzzleTest) {
        F root = buildRoot(puzzleTest);
        sizeRoot(root, 0);
        long total = 70000000;

        long needed = 30000000 - (total - root.getSize());
        List<F> folders = size(root);
        return folders.stream().mapToLong(F::getSize).filter(s -> s >= needed).min().orElse(0);
    }

    private List<F> size(F f) {
        List<F> folders = new ArrayList<>();
        if (!f.getChildren().isEmpty()) {
            for (F child : f.getChildren().values()) {
                if (!child.getChildren().isEmpty())
                    folders.addAll(size(child));
            }
            folders.add(f);
        }
        return folders;
    }

    @Data
    static
    class F {
        private long size;
        private String name;
        private Map<String, F> children = new HashMap<>();
        private F father;

        public F(long size, String name, F father) {
            this.size = size;
            this.name = name;
            this.father = father;
        }

        @Override
        public String toString() {
            return "F{" + "size=" + size + ", name='" + name + '\'' + ", father=" + father + '}';
        }
    }

}
