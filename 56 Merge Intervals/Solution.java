/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return new LinkedList<Interval>();
        Comparator<Interval> mycompare = new Comparator<Interval>(){
			public int compare(Interval interval1,Interval interval2){
				//Interval interval1 = (Interval)o1;
				//Interval interval2 = (Interval)o2;
				if(interval1.start<interval2.start){return -1;}
				else if(interval1.start==interval2.start){
					//there is no need to sort the intervals according to the end parameters
					//if(interval1.end<interval2.end){return -1;}
					//else if(interval1.end>interval2.end){return 1;}
					//else {return 0;}
					return 0;
				}
				else{return 1;}
			}
		};
		Collections.sort(intervals,mycompare);
		Interval tmp = intervals.get(0);
		Interval conference = new Interval(tmp.start,tmp.end);
		List<Interval> retlist=new LinkedList<Interval>();
		
		for(int i=1;i<intervals.size();i++){
			Interval thisinter = intervals.get(i);
			if(thisinter.start>=conference.start&&thisinter.end<=conference.end){
				continue;
			}
			
			if(conference.end>=thisinter.start&&conference.end<thisinter.end){
				conference.end=thisinter.end;
			}
			else{
				retlist.add(conference);
				conference = new Interval(thisinter.start,thisinter.end);
			}
		}
		retlist.add(conference);
		return retlist;
    }
}