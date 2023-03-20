import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

// For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
// You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

// Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

 

// Example 1:

// Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
// Output: 2
// Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
// Example 2:

// Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
// Output: -1





class Solution {
    public static int numBusesToDestination(int[][] routes, int S, int T) {
      int n = routes.length;
      
      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
      for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < routes[i].length ; j++){
              int bustopno = routes[i][j];
              ArrayList<Integer> busno = map.getOrDefault(bustopno, new ArrayList<>());
              busno.add(i);
              map.put(bustopno,busno);
          }
      }
      
      int level = 0;
      LinkedList<Integer> queue = new LinkedList<>();
      HashSet<Integer> busvis = new HashSet<>();
      HashSet<Integer> bustopvis = new HashSet<>();
      queue.addLast(S);
      bustopvis.add(S);
      while(queue.size() > 0){
          int size = queue.size();
          while(size-- > 0){
              int rem = queue.remove();
              
              if(rem == T){
                  return level;
              }
              
              ArrayList<Integer> buses = map.get(rem);
              for(int bus : buses){
                  if(busvis.contains(bus) == true){
                      continue;
                  }
                  int [] arr = routes[bus];
                  for(int bustop : arr){
                      if(bustopvis.contains(bustop) == true){
                          continue;
                      }
                      queue.addLast(bustop);
                  bustopvis.add(bustop);
                  }
                  busvis.add(bus);
              }
          }
          level++;
      }
      return -1;
      
  }
}