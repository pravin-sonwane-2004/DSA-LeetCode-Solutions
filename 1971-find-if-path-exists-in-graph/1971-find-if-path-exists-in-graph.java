import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Base case: if source and destination are the same
        if (source == destination) return true;

        // Step 1: Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Initialize BFS structures
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // If we've reached our destination
            if (currentNode == destination) {
                return true;
            }

            // Traverse all neighbors
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Destination wasn't reachable
        return false;
    }
}
