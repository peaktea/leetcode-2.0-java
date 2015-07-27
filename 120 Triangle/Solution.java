public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null||triangle.size()==0) return 0;
		int num=triangle.get(triangle.size()-1).size();
		List<Integer> tmplist = triangle.get(num-1);
        int []sum = new int[num];
		for(int i=0;i<num;i++) sum[i]=tmplist.get(i);
		for(int level=num-1;level>=1;level--){
			List<Integer> listone = triangle.get(level-1);
			for(int i=0;i<listone.size();i++){
				int res = listone.get(i)+Math.min(sum[i],sum[i+1]);
				sum[i]=res;
			}
		}
		return sum[0];
    }
}