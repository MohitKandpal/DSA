/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        int n = 5;
        System.out.println("Valid Tree: - " + isValidTree(edges, n));
    }

    private static boolean isValidTree(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        if(!dfs(0, -1, adj, visited))
            return false;
        return visited.size() == n;
    }

    private static boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if(visited.contains(node))
            return false;
        visited.add(node);
        for(int adjEle: adj.get(node)) {
            if(adjEle == parent)
                continue;
            if(!dfs(adjEle, node, adj, visited))
                return false;
        }
        return true;
    }
}
