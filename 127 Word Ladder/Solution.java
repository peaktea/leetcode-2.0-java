import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
			Set<String> set = new HashSet<String>();
			Queue<String> queue=new LinkedList<String>();
			queue.add(beginWord);
			set.add(beginWord);
			int level=1;
			while(!queue.isEmpty()){
				level++;
				Queue<String> tmpqueue = new LinkedList<String>();
				while(!queue.isEmpty()){
					String wordone=queue.poll();
					StringBuffer wordonebuffer = new StringBuffer(wordone);
					for(int i=0;i<wordone.length();i++){//for each index
						char originalchar=wordonebuffer.charAt(i);
						for(char c='a';c<='z';c++){//for each substitute
							wordonebuffer.setCharAt(i,c);
							String tmpstring=wordonebuffer.toString();//toString is time consuming, do this operation once
							if(set.contains(tmpstring)) 
								continue;
							else {
								if(tmpstring.compareTo(endWord)==0){//reach the end
									return level;
								}
								if(wordDict.contains(tmpstring)){//if not the word in dictionary, do not need to add into the wait queue
									tmpqueue.add(tmpstring);
									set.add(tmpstring);
								}
							}
						}
						wordonebuffer.setCharAt(i,originalchar);
					}
				}
				queue.addAll(tmpqueue);
			}
			return 0;
    }
}