class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);
            
            if(anagramMap.containsKey(sortedString))
                anagramMap.get(sortedString).add(s);
            else {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                anagramMap.put(sortedString, tempList);
            }
        }

        for(List<String> list : anagramMap.values())
            result.add(list);

        return result;
    }
}
