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
        if (intervals.isEmpty())
            return true;
        
        Interval lastMeetingTime;
        intervals.sort((a, b) -> a.start - b.start);

        lastMeetingTime = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curMeetingTime = intervals.get(i);
            if (curMeetingTime.start < lastMeetingTime.end) {
                return false;
            } else {
                lastMeetingTime.start = Math.min(lastMeetingTime.start, curMeetingTime.start);
                lastMeetingTime.end = Math.max(lastMeetingTime.end, curMeetingTime.end);
            }
        }

        return true;

    }
}
