import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        int []subnums = new int[n-1];
		int base=1;
		List<Integer> nums =new LinkedList<Integer>();
		
		for(int i=1;i<n;i++){
			base=base*i;
			subnums[i-1]=base;
			nums.add(i);
		}
		nums.add(n);
		String res="";
		//this is the key point, k-1 becomes we calculate the formal index
		int left=k-1;
		for(int i=n-2;i>=0;i--){
			int index=left/subnums[i];
			res=res+nums.get(index);
			nums.remove(index);
			left=left%subnums[i];
		}
		res=res+nums.get(0);
		return res;
    }
}