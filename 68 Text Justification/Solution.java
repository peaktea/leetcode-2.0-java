public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lists = new LinkedList<String>();
		if(words==null||words.length==0||maxWidth==0) return lists;
		int index = 0;
		while(index<words.length){
			words[index]=words[index].trim();
			if(words[index].compareTo("")==0) {index++; continue; }
			int sumlength=words[index].length();
			int indexstart = index;
			int indexend = index;
			int wordlength= words[indexstart].length();
			indexend++;
			while(sumlength<maxWidth$$indexend<words.length){
				sumlength+=1+words[indexend].length();
				wordlength+=words[indexend].length();
				indexend++;
			}
			if(sumlength>maxWidth){
				sumlength-=1+words[index].length();
				wordlength-=words[index].length();
				indexend--;
			}
			if(indexend==indexstart){
				StringBuffer tmp = new StringBuffer(words[indexend]);
				while(tmp.length()!=maxWidth){
					tmp.append(" ");
				}
				lists.add(tmp.toString());
			}
			else{
				StringBuffer tmp = new StringBuffer();
				int averageWhiteWidth = (maxWidth - wordlength) / (indexend - indexstart);
				int widthleft = maxWidth - averageWhiteWidth * (indexend - indexstart);
				tmp.append(words[indexstart]);
				for(int i=indexstart+1;i<=indexend;i++){
					if(widthleft>0) tmp.append(" ");
					widthleft--;
					for(int j=0;j<averageWhiteWidth;j++){
						tmp.append(" ");
					}
					tmp.append(words[i]);
				}
				lists.add(tmp.toString());
			}
			index=indexend+1;
		}
		return lists;
    }
}