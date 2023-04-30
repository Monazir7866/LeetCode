// Alice and Bob have an undirected graph of n nodes and three types of edges:

// Type 1: Can be traversed by Alice only.
// Type 2: Can be traversed by Bob only.
// Type 3: Can be traversed by both Alice and Bob.
// Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

// Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 

// Example 1:



// Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
// Output: 2
// Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
// Example 2:



// Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
// Output: 0
// Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
// Example 3:



// Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
// Output: -1
// Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.


class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;
        int n;
        
        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int node) {
            while (node != parent[node])
                node = parent[node];
            
            return node;
        }
        
        public boolean merge(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if (parentA == parentB) return false;
            
            if (rank[parentA] >= rank[parentB]) {
                parent[parentB] = parentA;
                rank[parentA]++;
            } else {
                parent[parentA] = parentB;
                rank[parentB]++;
            }
            
            return true;
        }
        
        public int countSeparateComponents() {
            int cnt = 0;
            
            for (int i = 1; i <= n; i++) 
                if (parent[i] == i) 
                    cnt++;
            
            return cnt;
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int cnt = n;
        
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean status = ds.merge(e[1], e[2]);
                if (!status) cnt--;
            }
        }
        
        int[] parentCopy = new int[n+1];
        int[] rankCopy = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parentCopy[i] = ds.parent[i];
            rankCopy[i] = ds.rank[i];
        }
        
        // Let's run for Bob only
        for (int[] e : edges) {
            if (e[0] == 2) {
                boolean status = ds.merge(e[1], e[2]);
                if (!status) cnt--;
            }
        }
        
        if (ds.countSeparateComponents() > 1) {
            return -1;
        } 
        
        ds.parent = parentCopy;
        ds.rank = rankCopy;
        
        // Let's run for Alice only
        for (int[] e : edges) {
            if (e[0] == 1) {
                boolean status = ds.merge(e[1], e[2]);
                if (!status) cnt--;
            }
        }
        
        if (ds.countSeparateComponents() > 1) {
            return -1;
        } 
        
        return n-cnt;
    }
}