/**
 * There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
 * The nodes are numbered from 0 to n - 1.
 * Return the total number of connected components in that graph.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {4,5}};
        int n = 6;
        System.out.println("Number of connected components: - " + findConnectedComponents(edges, n));
    }

    private static int findConnectedComponents(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                result++;
            }
        }
        return result;
    }

    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for(int v: adj.get(u)) {
            if(!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
