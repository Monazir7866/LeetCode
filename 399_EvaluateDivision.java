// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

// Return the answers to all queries. If a single answer cannot be determined, return -1.0.

// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

// Example 1:

// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// Explanation: 
// Given: a / b = 2.0, b / c = 3.0
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// Example 2:

// Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: [3.75000,0.40000,5.00000,0.20000]
// Example 3:

// Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
// Output: [0.50000,2.00000,-1.00000,-1.00000]



class Solution {
    HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
    public class Pair{
        String v;
        double w;
        Pair(String v, double w){
            this.v = v;
            this.w = w;
        }
        public String toString(){
            return v + " " + w;
        }
    }
    
    public double dfs(String src, String dest, HashSet<String> vis){
        vis.add(src);
        if(src.equals(dest)) return 1;
        double ans = 1;
        for(Pair e : graph.get(src)){
            if(!vis.contains(e.v)){
                double ret = dfs(e.v, dest, vis);
                if(ret > 0) return e.w * ret;
            }
        }
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] qAnswer = new double[queries.size()];
        for(int i = 0 ; i < equations.size() ; i++){
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 1/w));
        }
        
        for(int i = 0 ; i < queries.size() ; i++){
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            double q = graph.containsKey(u) ? dfs(u, v, new HashSet<>()) : -1.0;
            qAnswer[i] = q;
        }
        
        return qAnswer;
    }
}