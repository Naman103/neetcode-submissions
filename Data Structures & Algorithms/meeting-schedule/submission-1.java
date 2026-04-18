/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> { if(a.start == b.start)
        return a.end - b.end;
        else
        return a.start - b.start; });
        int prevStart = -1, prevEnd = -1;
        for(Interval interval : intervals) {
            if(prevStart == -1) {
                prevStart = interval.start;
                prevEnd = interval.end;
            } else {
                if(interval.start < prevEnd)
                    return false;
                
                prevStart = interval.start;
                prevEnd = interval.end;
            }
        }

        return true;
    }
}
