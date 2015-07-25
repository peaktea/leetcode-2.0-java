public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		//below code is a trick, if loop from index =0 , then error
		//because if m is larger than n, then some elements in nums1 will rewrite and 
		//becomes twinkle.
        for(int i=m-1;i>=0;i--){
			nums1[i+n]=nums1[i];
		}
		int pc=0;
		int p1=n;
		int p2=0;
		while(p1<m+n&&p2<n){
			if(nums1[p1]<nums2[p2]){
				nums1[pc]=nums1[p1];
				p1++;
			}else{
				nums1[pc]=nums2[p2];
				p2++;
			}
			pc++;
		}
		while(p1<(m+n)){
			nums1[pc++]=nums1[p1++];
		}
		while(p2<n){
			nums1[pc++]=nums2[p2++];
		}
    }
}