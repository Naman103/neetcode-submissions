class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        if(h <= piles.length) return piles[n - 1];

        for(int k = 1; k <= piles[n - 1]; k++) {
            int time = 0;
            for(int i = 0; i < n; i++) { 
                time += piles[i] % k == 0 ? piles[i]/k : (piles[i]/k) + 1;
                if(time > h)
                    break;
            }
            
            if(time <= h)
                return k;
        }

        return piles[n - 1];
    }
}
