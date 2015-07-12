/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
import java.util.*;
//字符串匹配的高效算法有多个，比如KMP，BM算法等。这里使用KMP算法
/*
KMP算法的关键是求next数组，对于next数组可以有多种定义，这里的定义时，在该字符之前,包括这个字符，的部分字符串当中，最多的前缀长度，并且满足前缀长度等于后缀长度。
例如aabaa，a之前的最大前缀长度是2，所以next[4]=2;实际上这个值就是第next[k]+1个数字，也就是最大前缀的下一个数字。
如果我们要在当前最大前缀的基础上，求这个最大前缀的子前缀，并且满足上面的要求及最大，那么应该使用 k=next[k-1];，原因仍然是k是长度，所以k-1表示索引
*/
public class Solution {
	private int[] getnext(String needle){
		int next[]=new int[needle.length()];
		next[0]=0;
		int k=0;
		for(int i=1;i<needle.length();i++){
			//下面的while循环实际上在遍历长度为k的子串当中的子相等前缀
			//比如 abac ... aba(0 0 1 .... 1 2 3),我们发现 aba aba是一个比较大的前缀，这前缀有一个后缀和他相等，如果要在这个后缀的后面放一个字符，就等同于在这个前缀的后面放一个字符，或者说，可以使用
			//前缀来加以验证比如这里要放入b,当前k是3，那么3所对应的字符为c是和b不相等的，那么继续需要在aba当中找发现下一个是b，正好想等，所以next值为2
			while(k>0&&needle.charAt(k)!=needle.charAt(i)){
				k=next[k-1];
			}
			if(needle.charAt(k)==needle.charAt(i)){
				k++;
			}
			next[i]=k;
		}
		return next;
	}
    public int strStr(String haystack, String needle) {
		if(needle.length()==0&&haystack.length()==0)return 0;
		if(needle.length()==0)return 0;
		if(haystack.length()==0) return -1;
        int next[]=getnext(needle);
        int i=0;
        int q=0;
		for(;i<haystack.length();i++){
			while(q>0&&haystack.charAt(i)!=needle.charAt(q)){
				q=next[q-1];
			}
			if(haystack.charAt(i)==needle.charAt(q)){ //实际上这里就是计数
				q++;
			}
			if(q==needle.length()){
				return (i-q+1); 
			}
		}
		return -1;
    }
}