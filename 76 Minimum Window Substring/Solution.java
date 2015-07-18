import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
		String res="";

		Map<Character,Integer> sumcount = new HashMap<Character,Integer>();
		Map<Character,Integer> tmpcount = new HashMap<Character,Integer>();
		int sum=t.length();
		for(int i=0;i<t.length();i++){
			if(!sumcount.containsKey(t.charAt(i))){
				sumcount.put(t.charAt(i),1);
				tmpcount.put(t.charAt(i),0);
			}else{
				sumcount.put(t.charAt(i),sumcount.get(t.charAt(i))+1);
			}
		}
		
		int count=0;
		int left=0;
		int minlength=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
			char thisc=s.charAt(i);
			if(sumcount.containsKey(thisc)){
				int n=0;
				if(tmpcount.containsKey(thisc)){
					n=tmpcount.get(thisc)+1;
					//this is corner case, because the n has been incresed, so
					// we should test if n is equal to sumcount.get(thisc)
					if(n<=sumcount.get(thisc)){
						count++;
					}
					tmpcount.put(thisc,n);
				}
			}else{
				//if nonsense character, we just pass it because we do not need to
				//consider it, it has no effect
				continue;
			}
			// in fact, if the first count==sum accurs, then the next loop we always t
			// get the true test,here, the count will not decrease.
			// Once encounter one character in the tmpcount map, we should do the window
			// shrinking here
			if(count==sum){
				//find the minimum window which ends with the index i
				//find the start index
				for(;left<=i;left++){
					char charc = s.charAt(left);
					if(tmpcount.containsKey(charc)){
						int n=tmpcount.get(charc);
						if(n==sumcount.get(charc)){
							break;
						}else{
							tmpcount.put(charc,n-1);
						}
					}else{
						continue;
					}
				}
				int thislength = i-left+1;
				//minlength=minlength>thislength?thislength:minlength;
				if(thislength<minlength){
					minlength=thislength;
					res=s.substring(left,i+1);
				}
			}
		}
		return res;
    }
}