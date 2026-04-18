class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValueOfK = Arrays.stream(piles).max().getAsInt();
        int minValueOfK = 1;
        int result = maxValueOfK;
        while(minValueOfK <= maxValueOfK) {
            int midValueOfK = (minValueOfK + maxValueOfK)/2;
            long totalTime = 0;
            for (int pile : piles)
                totalTime += Math.ceil((double) pile / midValueOfK);

            if (totalTime <= h) {
                result = midValueOfK;
                maxValueOfK = midValueOfK - 1;
            } else {
                minValueOfK = midValueOfK + 1;
            }
        }

        return result;
    }
}
