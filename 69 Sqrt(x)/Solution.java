public class Solution {
    /*
        here there are some corner cases here,
        1. left + right may be over lap, so convert them to the double formate
        2. how to determin which one is the result, right or left?? confused!! so return the less one.
        3.
    */
    public int mySqrt(int x) {
		double left=1;
		double right=x;
		
        while(left<=right){
			int mid=(int)(( left + right )/2);
			double powres = Math.pow(mid,2);
			if(powres==x) return mid;
			if(powres<x){
				left=mid+1;
			}
			if(powres>x){
				right=mid-1;
			}
		}
		if(Math.pow(left,2)<x) return (int)left;
		else return (int)right;
    }
}