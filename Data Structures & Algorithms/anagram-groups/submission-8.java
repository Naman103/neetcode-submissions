class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            String mapKey = fetchKey(s);
            if (anagramMap.containsKey(mapKey))
                anagramMap.get(mapKey).add(s);
            else {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                anagramMap.put(mapKey, tempList);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }

    private String fetchKey(String s) {
        char[] strArray = s.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);
    }
}
