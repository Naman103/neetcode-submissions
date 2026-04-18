class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        if(h <= piles.length) return piles[n - 1];

        int startK = 1, endK = piles[n - 1], res = -1;
        while(startK <= endK) {
            int midK = (int)Math.floor((startK + endK) / 2);
            int time = 0;
            for(int i = 0; i < n; i++) { 
                time += piles[i] % midK == 0 ? piles[i]/midK : (piles[i]/midK) + 1;
            }
            
            System.out.println(midK + " | " + time);
            if(time <= h) {
                res = midK;
                endK = midK - 1;
            } else
                startK = midK + 1;
        }

        return res;
    }
}
