public class Solution {
	private int findkth(int []nums1, int start1, int s1, int [] nums2, int start2, int s2, int k){
		if(s1>s2) return findkth(nums2,start2,s2,nums1,start1,s1,k);
		if(s1==0) return nums2[start2+k-1];
		if(k==1) return Math.min(nums1[start1],nums2[start2]);
		int pa=Math.min(s1,k/2);
		int pb=k-pa;
		if(nums1[start1+pa-1]<nums2[start2+pb-1]){
			return findkth(nums1,start1+pa,s1-pa,nums2,start2,s2,k-pa);
		}
		else{
			return findkth(nums1,start1,s1,nums2,start2+pb,s2-pb,k-pb);
		}
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
		int n=nums2.length;
		int mn=m+n;
		if(mn%2==1){
		    //we should pay attention to the last parameter, it means the rank, other than the index, so it starts from 1 not 0.
			int res=findkth(nums1,0,m,nums2,0,n,mn/2+1);
			return (double)res;
		}
		else{
			int res1=findkth(nums1,0,m,nums2,0,n,mn/2);
			int res2=findkth(nums1,0,m,nums2,0,n,mn/2+1);
			return ((double)res1+(double)res2)/2;
		}
    }
}