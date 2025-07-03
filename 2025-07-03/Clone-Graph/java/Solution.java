import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    private static HashMap<Node,Node> hm = new HashMap<>();

    public Node cloneGraph( Node node ){
        if( node == null ){
            return null;
        }
        return clone(node);
    }    

    private Node clone( Node node ){
        if(hm.containsKey(node)){
            return hm.get(node);
        }

        Node newNode = new Node( node.val ) ;
        hm.put( node , newNode );

        for( Node n : node.neighbors ){
            newNode.neighbors.add(clone(n));
        }

        return newNode;
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node clonedGraph1 = new Solution().cloneGraph(node1);
        System.out.println("Cloned Node Value: " + clonedGraph1.val);
        System.out.println("Cloned Node Neighbors: " + clonedGraph1.neighbors.stream().map(n -> n.val).toList()); // Expected: [2, 4]

        // Test Case 2
        System.out.println("Test Case 2:");
        Node singleNode = new Node(1);
        Node clonedGraph2 = new Solution().cloneGraph(singleNode);
        System.out.println("Cloned Node Value: " + clonedGraph2.val);
        System.out.println("Cloned Node Neighbors: " + clonedGraph2.neighbors.stream().map(n -> n.val).toList()); // Expected: []

        // Test Case 3
        System.out.println("Test Case 3:");
        Node clonedGraph3 = new Solution().cloneGraph(null);
        System.out.println("Cloned Graph: " + clonedGraph3); // Expected: null
    }
}
