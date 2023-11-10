package aoc;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

class D12 {

    private static Node[][] build(List<String> puzzle) {
        int rowSize = puzzle.size();
        int lineSize = puzzle.get(0).length();
        Node[][] matrix = new Node[rowSize][lineSize];
        for (int x = 0; x < rowSize; x++) {
            char[] line = puzzle.get(x).toCharArray();
            for (int y = 0; y < lineSize; y++) {
                matrix[x][y] = new Node(x, y, line[y], Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    private Node findStart(Node[][] puzzle) {
        for (int line = 0; line < puzzle.length; line++) {
            for (int row = 0; row < puzzle[line].length; row++) {
                if (puzzle[line][row].level == 'S') {
                    Node start = puzzle[line][row];
                    //heuristic to go to exit is MAX_VALUE as we don't know how to go there
                    start.cost = 0;
                    start.level = 'a' - 1;
                    puzzle[line][row] = start;
                    return start;
                }
            }
        }
        throw new IllegalStateException("Should have returned start");
    }

    private Node findExit(Node[][] puzzle) {
        for (int line = 0; line < puzzle.length; line++) {
            for (int row = 0; row < puzzle[line].length; row++) {
                if (puzzle[line][row].level == 'E') {
                    Node exit = puzzle[line][row];
                    exit.level = 'z' + 1;
                    puzzle[line][row] = exit;
                    return exit;
                }
            }
        }
        throw new IllegalStateException("Should have returned start");
    }

    private List<Node> findStarts(Node[][] puzzle) {
        List<Node> starts = new ArrayList<>();
        for (Node[] nodes : puzzle) {
            for (int row = 0; row < nodes.length; row++) {
                if (nodes[row].level == 'a') {
                    Node start = nodes[row];
                    starts.add(start);
                }
            }
        }
        return starts;
    }

    public int one(List<String> puzzle) {
        Node[][] matrix = build(puzzle);
        Node start = findStart(matrix);
        Node exit = findExit(matrix);

        //follow the path
        Node e = findPath(matrix, start, exit);

        return e.cost;
    }

    private Node findPath(Node[][] matrix, Node start, Node exit) {
        Set<Node> closedList = new HashSet<>();
        closedList.add(start);
        //Comparing by level names
        Comparator<Node> levelSorter = Comparator.comparing(Node::getHeuristic);
        Queue<Node> openList = new PriorityQueue<>(levelSorter);
        openList.add(start);

        int rowLength = matrix.length;
        int lineLength = matrix[0].length;

        while (!openList.isEmpty()) {
            Node current = openList.poll();
//            debug(matrix, closedList, rowLength, lineLength);

            if (current.x == exit.x && current.y == exit.y) {
                debug(matrix, closedList, rowLength, lineLength);
                return current;
            }

            //find possible neighbors
            List<Node> neighbors = new ArrayList<>();
            //down
            if (current.x + 1 < rowLength && (matrix[current.x + 1][current.y].level <= current.level + 1))
                neighbors.add(matrix[current.x + 1][current.y]);
            //up
            if (current.x > 0 && (matrix[current.x - 1][current.y].level <= current.level + 1))
                neighbors.add(matrix[current.x - 1][current.y]);
            //right
            if (current.y + 1 < lineLength && (matrix[current.x][current.y + 1].level <= current.level + 1))
                neighbors.add(matrix[current.x][current.y + 1]);
            //left
            if (current.y > 0 && (matrix[current.x][current.y - 1].level <= current.level + 1))
                neighbors.add(matrix[current.x][current.y - 1]);

            for (Node n : neighbors) {
                int newCost = current.cost + 1;
                if (!(closedList.contains(n) ||
                        openList.stream().anyMatch(o -> o.x == n.x && o.y == n.y && newCost < n.cost)
                )) {
                    n.cost = newCost;
                    n.heuristic = newCost + calcDist(n, exit);
                    openList.add(n);
                }
                closedList.add(n);
            }
        }
        throw new IllegalStateException("No route found");
    }

    private static void debug(Node[][] matrix, Set<Node> closedList, int rowLength, int lineLength) {
        //debug
        List<String> coord = closedList.stream().map(n -> {
            return Integer.toString(n.x) + n.y;
        }).toList();

        for (int x = 0; x < rowLength; x++) {
            for (int y = 0; y < lineLength; y++) {
                if (coord.contains(Integer.toString(x) + y))
                    System.out.print((char) 27 + "[33m" + StringUtils.leftPad(String.valueOf(matrix[x][y].cost), 4) + (char) 27 + "[0m");
                else System.out.print(StringUtils.leftPad(String.valueOf(matrix[x][y].level), 4));
            }
            System.out.println();
        }
        System.out.println("*****************");
    }

    private int calcDist(Node from, Node to) {
        return Math.abs(from.level - to.level);
    }

    public int two(List<String> puzzle) {
        Node[][] matrix = build(puzzle);
        Node start = findStart(matrix);
        Node exit = findExit(matrix);
        List<Node> starts = findStarts(matrix);
        starts.add(start);

        List<Node> paths = new ArrayList<>();
        for (Node n : starts) {
            matrix = build(puzzle);
            //smell
            findExit(matrix);
            n.cost = 0;
            matrix[n.x][n.y] = n;
            try {
                paths.add(findPath(matrix, n, exit));
            } catch (IllegalStateException e) {
                System.out.println("no route here");
            }
        }
        return paths.stream().mapToInt(Node::getCost).min().orElse(0);

    }

    @Data
    static
    class Node implements Comparable<Node> {
        int x;
        int y;
        char level;
        int cost;
        int heuristic;


        public Node(int x, int y, char level, int cost, int heuristic) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.heuristic = heuristic;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n1) {
            return Integer.compare(this.heuristic, n1.heuristic);
        }
    }
}
