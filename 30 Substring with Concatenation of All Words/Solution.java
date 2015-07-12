/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters. 

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"] 

You should return the indices: [0,9].
 (order does not matter). 

*/
import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsize=words[0].length();
		Map<String,Integer> map =new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++){
			String wordone=words[i];
			if(map.containsKey(wordone)){
				int num = map.get(wordone);
				num++;
				map.put(wordone,num);
			}else{
				map.put(wordone,1);
			}
		}
		Map<String,Integer> countmap =new HashMap<String,Integer>();
		List<Integer> res = new LinkedList<Integer>();
		for(int i=0;i<=s.length()-words.length * wordsize;i++){
			countmap.clear();
			int k=0;
			for(;k<words.length;k++){//corner key: we only need words.length words, for loop is enough
				int j=i+k*wordsize;
				String wordone = s.substring(j,j+wordsize);
				if(map.containsKey(wordone)){
					int sumnum=map.get(wordone);
					if(countmap.containsKey(wordone)){
						int tmpsum = countmap.get(wordone);
						tmpsum++;
						if(tmpsum>sumnum) break;
						countmap.put(wordone,tmpsum);
					}else{
						countmap.put(wordone,1);
					}
				}else{//this is a corner case, if the wordone is not the element of map, then the validation can be canceled
				    break;
				}
			}
			if(k==words.length){
				res.add(i);
			}
		}
		return res;
    }
}