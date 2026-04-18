class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sortedString = new String(sArray);

            if(anagramMap.containsKey(sortedString))
                anagramMap.get(sortedString).add(s);
            else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                anagramMap.put(sortedString, anagramList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> anagramList : anagramMap.values()) {
            result.add(anagramList);
        }

        return result;
    }
}
