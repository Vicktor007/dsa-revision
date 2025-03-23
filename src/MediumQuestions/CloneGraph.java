package MediumQuestions;

import java.util.*;

public class CloneGraph {
    /**
     Clone Graph

     Given a reference of a node in a connected undirected graph.
     Return a deep copy (clone) of the graph.
     Each node in the graph contains a value (int) and a list (List(Node)) of its neighbors.
     class Node {
     public int val;
     public List<Node> neighbors;
     }
     Test case format:
     For simplicity, each node's value is the same as the node's index (1-indexed).
     For example, the first node with val1, the second node with val2, and so on.
     The graph is represented in the test case using an adjacency list.
     An adjacency list is a collection of unordered lists used to represent a finite graph.
     Each list describes the set of neighbors of a node in the graph.
     The given node will always be the first node with val 1.
     You must return the copy of the given node as a reference to the cloned graph.
     */

    class Node  {
        public int val;
        public List<Node> neighbours;
        public Node(){
            val = 0;
            neighbours = new ArrayList<Node>();
        }
        public Node(int _val){
            val = _val;
            neighbours  = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbours){
            val = _val;
            neighbours = _neighbours;
        }
    }


    public Node cloneGraphDFS(Node node){
        if (node == null){
            return null;
        }

//        Use a map to keep track of visited nodes and tier clones
        Map<Node,Node> visited = new HashMap<>();

//        create a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

//        clone te root node and add it to the visited map
        visited.put(node, new Node(node.val));

        while (!queue.isEmpty()){
            Node current = queue.poll();

//            traverse neighbours
            for (Node neighbour : current.neighbours){
                if (!visited.containsKey(neighbour)){
//                    clone and store the neighbour node in visited map
                    visited.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
//                connect the clone of the current node to the clone of the neighbour
            }

        }
//        return the clone of te root node
        return visited.get(node);
    }

    /**
     How it works:
     HashMap (visited): Tracks the mapping between the original node and its clone. This ensures we don't recreate a node twice.

     Breadth-First Search (BFS): Traverses the graph using a queue to process each node and its neighbors systematically.

     Clone and Connect: Creates clones of the nodes and their connections without modifying the original graph.
     */

    // Map to store visited nodes and their clones
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node is already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Recursively clone the neighbors
        for (Node neighbour : node.neighbours) {
            cloneNode.neighbours.add(cloneGraph(neighbour));
        }

        return cloneNode;
    }
    /**
     How it works:
     Recursive Cloning:

     The cloneGraph method uses recursion to create clones of nodes and their neighbors.

     It checks if the current node has already been cloned (to avoid infinite loops in cyclic graphs).

     HashMap (visited):

     This map ensures that each node is cloned only once and helps maintain the structure of the graph.

     Base Condition:

     If the node is null, the method returns null.

     If the node is already cloned, it retrieves the clone from the visited map.
     */
}
