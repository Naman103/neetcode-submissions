class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sortedS = new String(charArray);
            if(anagramMap.containsKey(sortedS))
                anagramMap.get(sortedS).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                anagramMap.put(sortedS, list);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }
}
