/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ... 

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.


Given an integer n, generate the nth sequence. 

Note: The sequence of integers will be represented as a string. 

*/
/*
	example: 1,11,21,1211,111221£¬312211£¬13112221£¬1113213211
*/
public class Solution {
    String countAndSayForOneString(String input) {
        char tmp = input.charAt(0);
        int  num = 1;
        StringBuffer newString = new StringBuffer("");
        for(int k=1;k<input.length();k++) {
            if(input.charAt(k)==tmp) {
        		num++;
        		continue;
        	}
        	newString.append(Integer.toString(num) + tmp);
        	tmp = input.charAt(k);
        	num = 1;
        }
        newString.append(Integer.toString(num) + tmp);
        return newString.toString();
    }
    
    public String countAndSay(int n) {
        String result = "1";
		int i = 1;
		while(i<n) {
        	result = countAndSayForOneString(result);
    		i++;
        }
		return result;
    }
}