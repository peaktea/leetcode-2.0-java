public class Solution {
    public int[] plusOne(int[] digits) {
        int pre=1;
		for(int i=digits.length-1;i>=0;i--){
			int sum=pre+digits[i];
			int digit = sum %10;
			digits[i]=digit;
			pre=sum/10;
		}
		if(pre==0) return digits;
		else{
			int [] arr = new int[digits.length+1];
			arr[0]=1;
			for(int =1;i<arr.length;i++){
				arr[i]=digits[i-1];
			}
			return arr;
		}
    }
}