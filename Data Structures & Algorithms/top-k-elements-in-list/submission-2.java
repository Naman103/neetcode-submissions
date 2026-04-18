class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //prepare frequencyMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else
                frequencyMap.put(nums[i], 1);
        }

        HashMap<Integer, List<Integer>> freqValueMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> keyValue : frequencyMap.entrySet()) {
            if(freqValueMap.containsKey(keyValue.getValue())) {
                freqValueMap.get(keyValue.getValue()).add(keyValue.getKey());
            } else {
                List<Integer> vList = new ArrayList<>();
                vList.add(keyValue.getKey());
                freqValueMap.put(keyValue.getValue(), vList);
            }
        }

        int i = 0, j = k;
        List<Integer> allFrequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(allFrequencies, Collections.reverseOrder());
        Set<Integer> uniqueFrequencies = new LinkedHashSet<>();
        for(int l = 0; l < allFrequencies.size(); l++)
            uniqueFrequencies.add(allFrequencies.get(l));

        List<Integer> result = new ArrayList<>();
        List<Integer> tempStore = new ArrayList<>();
        for(int freq : uniqueFrequencies) {
            if(j <= 0)
                break;
            tempStore = freqValueMap.get(freq);
            for(int value : tempStore) {
                if(j <= 0)
                    break;
                result.add(value);
                j--;
            }
        }

        return result.stream().mapToInt(Integer:: intValue).toArray();
    }
}
