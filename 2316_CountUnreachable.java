import java.util.ArrayList;

// You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

// Return the number of pairs of different nodes that are unreachable from each other.

 

// Example 1:


// Input: n = 3, edges = [[0,1],[0,2],[1,2]]
// Output: 0
// Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
// Example 2:


// Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
// Output: 14
// Explanation: There are 14 pairs of nodes that are unreachable from each other:
// [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
// Therefore, we return 14.


class Solution {
    public int dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis){
        vis[i] = true;
         int count = 1;

        for(int ed : adj.get(i)){
            if(!vis[ed]){
                count += dfs(adj, ed, vis);
            }
        }
       return count;
    }
    public long countPairs(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<Integer>());
        }
       for(int d[]:edges){
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        int a = 0;
        boolean[] vis = new boolean[n];
        long ans = 0;
        for(int k = 0; k < n; k++){
            if(!vis[k]){
               int count = dfs(adj, k, vis);
            
            ans+= (long)count*a;
            a += count;
            }
       }
       
    
       return ans;
    }
}