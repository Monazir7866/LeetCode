import java.util.Arrays;

// An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.

// Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

// Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, and false otherwise.

 

// Example 1:


// Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
// Output: [false,true]
// Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with distances 2 and 16.
// For the first query, between 0 and 1 there is no path where each distance is less than 2, thus we return false for this query.
// For the second query, there is a path (0 -> 1 -> 2) of two edges with distances less than 5, thus we return true for this query.
// Example 2:


// Input: n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
// Output: [true,false]
// Exaplanation: The above figure shows the given graph.



class UnionFind {
    public UnionFind(int n) {
      id = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; ++i)
        id[i] = i;
    }
  
    public void unionByRank(int u, int v) {
      final int i = find(u);
      final int j = find(v);
      if (i == j)
        return;
      if (rank[i] < rank[j]) {
        id[i] = id[j];
      } else if (rank[i] > rank[j]) {
        id[j] = id[i];
      } else {
        id[i] = id[j];
        ++rank[j];
      }
    }
  
    public int find(int u) {
      return id[u] == u ? u : (id[u] = find(id[u]));
    }
  
    private int[] id;
    private int[] rank;
  }
  
  class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
      boolean[] ans = new boolean[queries.length];
      int[][] qs = new int[queries.length][4];
      UnionFind uf = new UnionFind(n);
  
      for (int i = 0; i < queries.length; ++i) {
        qs[i][0] = queries[i][0];
        qs[i][1] = queries[i][1];
        qs[i][2] = queries[i][2];
        qs[i][3] = i;
      }
  
      Arrays.sort(qs, (a, b) -> a[2] - b[2]);
      Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
  
      int i = 0; // i := edgeList's index
      for (int[] q : qs) {
        // Union edges whose distances < limit (q[2])
        while (i < edgeList.length && edgeList[i][2] < q[2])
          uf.unionByRank(edgeList[i][0], edgeList[i++][1]);
        if (uf.find(q[0]) == uf.find(q[1]))
          ans[q[3]] = true;
      }
  
      return ans;
    }
  }