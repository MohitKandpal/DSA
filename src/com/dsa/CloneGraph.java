/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 */
package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);

        firstNode.neighbors = Arrays.asList(secondNode, fourthNode);
        secondNode.neighbors = Arrays.asList(firstNode, thirdNode);
        thirdNode.neighbors = Arrays.asList(secondNode, fourthNode);
        fourthNode.neighbors = Arrays.asList(firstNode, thirdNode);

        Node clonedGraph = CloneGraph.getClonedGraph(firstNode);
    }

    public static Node getClonedGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        if(node == null)
            return null;
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        for(Node neighbor: node.neighbors) {
            if(!map.containsKey(neighbor.val)) {
                getClonedGraph(neighbor);
            }
        }

        for(Node neighbor: node.neighbors) {
            clonedNode.neighbors.add(map.get(neighbor.val));
        }
        return clonedNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
