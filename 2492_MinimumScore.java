import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

// The score of a path between two cities is defined as the minimum distance of a road in this path.

// Return the minimum possible score of a path between cities 1 and n.

// Note:

// A path is a sequence of roads between two cities.
// It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
// The test cases are generated such that there is at least one path between 1 and n.
 

// Example 1:


// Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
// Output: 5
// Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
// It can be shown that no other path has less score.
// Example 2:


// Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
// Output: 2
// Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.



class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        Queue<Pair> qu=new LinkedList<>();
        boolean vis[]=new boolean[n+1];
        qu.add(new Pair(1,Integer.MAX_VALUE));
        int ans=Integer.MAX_VALUE;
        while(!qu.isEmpty()){
            Pair p=qu.poll();
            vis[p.node]=true;
            ans=Math.min(ans,p.dist);
            for(Pair adjcomp:adj.get(p.node)){
                if(!vis[adjcomp.node]){
                    qu.add(adjcomp);
                }
            }
        }
        return ans;
    }
}