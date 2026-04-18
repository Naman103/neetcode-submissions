class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> anagramMap = new HashMap<>();
       for(String s : strs) {
            char[] stringArray = s.toCharArray();
            Arrays.sort(stringArray);
            String sortString = new String(stringArray);
            if(anagramMap.containsKey(sortString))
                anagramMap.get(sortString).add(s);
            else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                anagramMap.put(sortString, anagramList);
            }
       }

    List<List<String>> result = new ArrayList<>();
       for(List<String> s : anagramMap.values())
        result.add(s);

        return result;  
    }
}
