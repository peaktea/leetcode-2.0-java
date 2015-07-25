public class Solution {
	public void backtrack(List<String> lists,String addr,String s,int index,int layer){
		if(index>=s.length()&&layer==5){
			addr=addr.trim();
			String strs[]= addr.split(" ");
			String addrs="";
			for(String ip:strs){
			    if(addrs.compareTo("")==0) addrs=ip;
			    else addrs=addrs+"."+ip;
			}
			lists.add(addrs);
			return;
		}
		for(int i=0;i<3&&(index+i)<s.length();i++){
			String digit=s.substring(index,index+i+1);
			if(digit.charAt(0)=='0'&&i!=0) return;
			int num = Integer.parseInt(digit);
			if(num>=0&&num<=255){
				backtrack(lists,addr+" "+digit,s,index+i+1,layer+1);
			}else{
				continue;
			}
		}
	}
    public List<String> restoreIpAddresses(String s) {
		List<String> list =new LinkedList<String>();
		if(s==null||s.length()<4||s.length()>12){
		    return list;
		}
		backtrack(list,"",s,0,1);
		return list;
    }
}