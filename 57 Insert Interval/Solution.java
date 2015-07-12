/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> newlist = new LinkedList<Interval>();
		boolean newIntervalInserted=false;
        for(int i=0;i<intervals.size();i++){
			Interval tmp = intervals.get(i);
			//the newInterval is on the right, so just add the tmp node, then test next node
			if(tmp.end<newInterval.start){
				newlist.add(tmp);
				continue;
			}
			//the newInterval is on the left, so just add the newInterval, then add 
			//the tmp node.
			if(tmp.start>newInterval.end){
				//insert it
				if(!newIntervalInserted){
					newlist.add(newInterval);
					newIntervalInserted=true;
				}
				newlist.add(tmp);
				continue;
			}
			//there is overlap, so fuse them, get the new newInterval.
			newInterval.start=Math.min(newInterval.start,tmp.start);
			newInterval.end=Math.max(newInterval.end,tmp.end);
			
		}
		if(!newIntervalInserted){
			newlist.add(newInterval);
		}
		return newlist;
    }
}