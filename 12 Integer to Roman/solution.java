/*
�������ֵ��ص�
I V X  L  C   D   M 
1 5 10 50 100 500 1000
1.С�������ڴ�����߱�ʾ������ȥС����С�������ڴ����ұߣ���ʾ��������С��
2.ͬһ�����ֳ��ֶ�Σ���ʾ�ۼ�
3. һ�㲻���������ֳ���3��
4����һ���������滭һ��ֱ�ߣ���ʾ����1000��
*/

public class Solution {
	private String setdigit(int digit,String d1,String d2,String d3){
		String str="";
		if(digit<4){
			for(int i=0;i<digit;i++){
				str+=d1;
			}
		}
		if(digit==4){
			str+=d1;
			str+=d2;
		}
		if(digit==5){
			str+=d2;
		}
		if(digit>5&&digit<9){
			str+=d2;
			for(int i=0;i<digit-5;i++){
				str+=d1;
			}
		}
		if(digit==9){
			str+=d1;
			str+=d3;
		}
		return str;
	}
    public String intToRoman(int num) {
        int d=num%10;
		int t=(num/10)%10;
		int h=(num/100)%10;
		int t2=(num/1000)%10;
		String res="";
		res=setdigit(d,"I","V","X")+res;
		res=setdigit(t,"X","L","C")+res;
		res=setdigit(h,"C","D","M")+res;
		res=setdigit(t2,"M","","")+res;
		return res;
    }
}