class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();


        // Sort Array based on start of interval
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        // add first element to the result
        result.add(intervals[0]);

        // last element of result will be compared with the first element
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                int[] curInterval = result.get(result.size() - 1);
                curInterval[0] = Math.min(curInterval[0], intervals[i][0]);
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]); 
    }
}
