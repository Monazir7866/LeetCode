// Design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:

// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

// Example:

// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True


// Solution


// class WordDictionary {
//     Map<Integer, List<String>> map = new HashMap<>();
// public void addWord(String word) {
//     int index = word.length();
// 	if (!map.containsKey(index)) {
// 	    List<String> list = new ArrayList<>();
// 	    list.add(word);
// 		map.put(index, list);
// 	} else {
// 		map.get(index).add(word);
// 	}
// }

// public boolean search(String word) {
//   int index = word.length();
//   if (!map.containsKey(index)) {
//       return false;
//   }
  
//   List<String> list = map.get(index);
//   for(String s : list) { 
//       if(isSame(s, word)) {
//           return true;
//       }
//   }
//   return false;
// }

// public boolean isSame(String s, String word) { 
//     for (int i = 0; i < s.length(); i++) {
//         if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
//             return false;
//         }
//     }
//     return true;
// }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */