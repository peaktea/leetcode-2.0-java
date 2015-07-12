import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String,List<String> > map = new HashMap<String,List<String> >();
		for(int i=0;i<strs.length;i++){
			String value=strs[i];
			String key=sortString(value);
			if(map.containsKey(key)){
				List<String> listone=map.get(key);
				listone.add(value);
			}else{
				List<String> listone=new LinkedList<String>();
				listone.add(value);
				map.put(key,listone);
			}
		}
		//loop the map, to get the one which is number larger than 1
		List<String> res=new LinkedList<String>();
		for(String key: map.keySet()){
			List listone=map.get(key);
			if(listone.size()>1){
				res.addAll(listone);
			}
		}
		return res;
    }
	private String sortString(String value){
		char [] k=value.toCharArray();
		Arrays.sort(k);
		return new String(k);
	}
}