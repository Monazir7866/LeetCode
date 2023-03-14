// Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

// However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

// Return the least number of units of times that the CPU will take to finish all the given tasks.

 

// Example 1:

// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation: 
// A -> B -> idle -> A -> B -> idle -> A -> B
// There is at least 2 units of time between any two same tasks.
// Example 2:

// Input: tasks = ["A","A","A","B","B","B"], n = 0
// Output: 6
// Explanation: On this case any permutation of size 6 would work since n = 0.
// ["A","A","A","B","B","B"]
// ["A","B","A","B","A","B"]
// ["B","B","B","A","A","A"]
// ...
// And so on.


class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] count = new int[26];
         int max = 0, maxCount = 0;
        
        for(char ch : tasks){
            count[ch-'A']++;
            if(count[ch-'A']==max){
                maxCount++;
            }else if(count[ch-'A']>max){
                max=count[ch-'A'];
                maxCount=1;
            }
        }
        return Math.max(tasks.length, (max-1)*(n+1) + maxCount);
    }
}