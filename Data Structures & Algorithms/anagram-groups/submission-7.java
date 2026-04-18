class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newS = new String(c);
            if(anagramMap.containsKey(newS))
                anagramMap.get(newS).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                anagramMap.put(newS, list);
            }    
        }
        return new ArrayList<>(anagramMap.values());
    }
}
