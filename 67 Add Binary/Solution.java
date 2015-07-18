public class Solution {
    public String addBinary(String a, String b) {
        a=a.trim();
		b=b.trim();
		int aindex=a.length()-1;
		int bindex=b.length()-1;
		StringBuffer res =new StringBuffer();
		int pre=0;
		while(aindex>=0&&bindex>=0){
			int sum = pre + (a.charAt(aindex) - '0') + (b.charAt(bindex)-'0');
			pre=sum/2;
			res.append(sum%2+"");
			aindex--;
			bindex--;
		}
		while(aindex>=0){
			int sum = pre +(a.charAt(aindex) - '0');
			pre = sum/2;
			res.append(sum%2+"");
			aindex--;
		}
		while(bindex>=0){
			int sum = pre +(b.charAt(bindex) - '0');
			pre = sum/2;
			res.append(sum%2+"");
			bindex--;
		}
		if(pre==1)
			res.append(""+1);
		res.reverse();
		return res.toString();
    }
}