public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<Integer>();
		int num = (int)Math.pow(2,n);
		for(int i=0;i<num;i++){
			int res = i^(i>>1);
			list.add(res);
		}
		return list;
    }
}