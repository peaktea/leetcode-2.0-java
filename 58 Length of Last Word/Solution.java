public class Solution {
    public int lengthOfLastWord(String s) {
		boolean started=false;
		int count=0;
        for(int i=s.length();i>=0;i--){
			char c=s.charAt(i);
			if(Character.isAlphabetic(c)){
				started=true;
				count++;
			}
			else{
				if(started){
					return count;
				}
			}
		}
		return count;
    }
}