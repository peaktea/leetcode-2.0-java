import java.util.*;

public class Solution {
	private void BF(List<List<String>> lists,List<String> list,String start,String end,Set<String> dict,Queue<String> queue){
		if(queue.isEmpty()) return;
		Queue<String> tmpqueue =new LinkedList<String>();
		while(!queue.isEmpty()){
			String wordone = queue.poll();
			StringBuffer wordonebuffer = new StringBuffer(wordone);
		}
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> lists =new LinkedList<List<String>>();
        Set<String> set = new HashSet<String>();
		Queue<String> queue=new LinkedList<String>();
		List<String> list =new LinkedList<String>();
		list.add(start);
		set.add(start);
		queue.add(start);
		while(!queue.isEmpty()){
			Queue<String> tmpqueue =new LinkedList<String>();
			while(!queue.isEmpty()){
				String wordone = queue.poll();
				StringBuffer wordonebuffer = new StringBuffer(wordone);
				for(int i=0;i<wordone.length();i++){//for each index
					char originalchar =  wordonebuffer.charAt(i);
					for(char c='a';c<='z';c++){//for each substitute
						wordonebuffer.setCharAt(i,c);
						String tmpstring =wordonebuffer.toString();
						if(set.contains(tmpstring)||!dict.contains(tmpstring)) continue;
						else{
							list.add(tmpstring);
							if(tmpstring.compareTo(end)==0){
								List<String> newlist = new LinkedList<String>;
								newlist.addAll(list);
								lists.add(newlist);
							}
							else{
								
							}
						}
					}
				}
			}
		}
    }
}