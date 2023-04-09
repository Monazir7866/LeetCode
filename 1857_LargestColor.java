import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

// You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

// A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

// Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

// Example 1:



// Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
// Output: 3
// Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
// Example 2:



// Input: colors = "a", edges = [[0,0]]
// Output: -1
// Explanation: There is a cycle from 0 to 0.






class Solution {
    static final int UNVISITED = Integer.MIN_VALUE;
    static final int CYCLE_FOUND = Integer.MIN_VALUE;

    static class Node {
        final int i;
        final List<Node> adjList;

        public Node(final int i) {
            this.i = i;
            this.adjList = new ArrayList<>();
        }
    }

    static int largestPathValue(Node node, String colors, char color, int[] visited, boolean[] processing) {
        if (visited[node.i] != UNVISITED) {
            return visited[node.i];
        }

        if (processing[node.i]) {
            return CYCLE_FOUND;
        }
        processing[node.i] = true;

        int res = 0;
        for (Node to : node.adjList) {
            int potential = largestPathValue(to, colors, color, visited, processing);
            
            if (potential == CYCLE_FOUND) {
                return CYCLE_FOUND;
            }

            res = Math.max(potential, res);
        }
        processing[node.i] = false;

        return visited[node.i] = res + (colors.charAt(node.i) == color ? 1 : 0);
    }

    public int largestPathValue(String colors, int[][] edges) {
        // process graph
        final int n = colors.length();

        final Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);
        }

        // convert edges into adjacency list
        for (int[] e : edges) {
            nodes[e[0]].adjList.add(nodes[e[1]]);
        }

        // get distinct colors
        Set<Character> distinctColors = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            distinctColors.add(colors.charAt(i));
        }

        // dfs on all colors
        int res = 0;
        for (char color : distinctColors) {
            int[] visited = new int[n];
            boolean[] processing = new boolean[n];
            for (int i = 0; i < n; ++i) {
                visited[i] = UNVISITED;
            }

            for (Node node : nodes) {
                int potential = largestPathValue(node, colors, color, visited, processing);

                if (potential == CYCLE_FOUND) {
                    return -1;
                }

                res = Math.max(potential, res);
            }
        }
        return res;
    }
}