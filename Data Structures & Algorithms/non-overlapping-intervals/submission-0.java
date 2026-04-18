class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> mergedIntervalList = new ArrayList<>();
        mergedIntervalList.add(intervals[0]);
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = mergedIntervalList.get(mergedIntervalList.size() - 1);

            if (curInterval[1] > intervals[i][0]) {
                // merge or add count
                result++;
                curInterval[0] = Math.min(curInterval[0], intervals[i][0]);
                curInterval[1] = Math.min(curInterval[1], intervals[i][1]);
            } else {
                mergedIntervalList.add(intervals[i]);
            }
        }

        return result;

    }
}
