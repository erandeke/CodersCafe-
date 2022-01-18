package medium;

import java.util.*;

/**
 * @author Kedar Erande
 */
class TreeDataStructure {
    int data;
    TreeDataStructure left;
    TreeDataStructure right;

    public TreeDataStructure(int data) {
        this.data = data;
        this.left = this.right = null;
    }


}


class Pair {
    TreeDataStructure root;
    int x;  //horizontal
    int y;  //stores level

    Pair(TreeDataStructure root, int x, int y) {
        this.root = root;
        this.x = x;
        this.y = y;
    }
}


public class VerticalOrderTraversal {
    TreeDataStructure root;

    public VerticalOrderTraversal() {
        root = null;
    }

    public List<List<Integer>> performVerticalOrderTraversal(TreeDataStructure ts) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Pair>> mapOfCoordinates = new HashMap<>();
        if (ts != null) {
            queue.offer(new Pair(ts, 0, 0));
        }
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            min = Math.min(min, p.x);
            max = Math.max(max, p.x);
            if (!mapOfCoordinates.containsKey(p.x))
                mapOfCoordinates.put(p.x, new ArrayList<>());
            mapOfCoordinates.get(p.x).add(p);

            //handle left and right nodes
            if (p.root.left != null) {
                queue.offer(new Pair(p.root.left, p.x - 1, p.y + 1));
            }
            if (p.root.right != null) {
                queue.offer(new Pair(p.root.right, p.x + 1, p.y + 1));
            }
        }
        //handle map operations from min to max get the result
        for (int i = min; i <= max; i++) {
            Collections.sort(mapOfCoordinates.get(i), new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    if (a.y == b.y) //when y is equal, sort it by value
                        return a.root.data - b.root.data;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < mapOfCoordinates.get(i).size(); j++) {
                subList.add(mapOfCoordinates.get(i).get(j).root.data);//{Pair : i--> 1,5,6}
            }
            list.add(subList);

        }
        return list;

    }


    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        verticalOrderTraversal.root = new TreeDataStructure(1);
        verticalOrderTraversal.root.left = new TreeDataStructure(2);
        verticalOrderTraversal.root.right = new TreeDataStructure(3);
        verticalOrderTraversal.root.left.left = new TreeDataStructure(4);
        verticalOrderTraversal.root.left.right = new TreeDataStructure(5);
        verticalOrderTraversal.root.right.left = new TreeDataStructure(6);
        verticalOrderTraversal.root.right.right = new TreeDataStructure(7);
        List<List<Integer>> list = verticalOrderTraversal.performVerticalOrderTraversal(verticalOrderTraversal.root);
        System.out.println(list);
    }
}