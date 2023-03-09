// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

// Example 1:

// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:

// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.




// Solution

// class Solution {
//     HashMap<String, Integer> map = new HashMap();
//     public List<String> topKFrequent(String[] words, int k) {
//         PriorityQueue<String> q = new PriorityQueue(k, new lexicComparator());
//         for(String w: words) {
//             if(!map.containsKey(w)) map.put(w, 1);
//             else map.put(w, map.get(w)+1);
//         }
//         map.forEach((key, v)->q.offer(key));
//         List<String> res = new ArrayList();
//         while(k-- > 0) res.add(q.poll());
//         return res;
//     }
//     class lexicComparator implements Comparator<String> {
//     public int compare(String s1, String s2) {
//         if(map.get(s1) == map.get(s2)) return s1.compareTo(s2);
//         return -map.get(s1)+map.get(s2);
//         }
//     }
// }