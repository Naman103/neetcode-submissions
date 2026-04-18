class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray())
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (tCount.containsKey(s.charAt(i))) {
                Map<Character, Integer> subStrMap = new HashMap<>();
                int left = i;
                String subString = "";
                while (left < s.length()) {
                    subString += s.charAt(left);
                    subStrMap.put(s.charAt(left), subStrMap.getOrDefault(s.charAt(left), 0) + 1);
                    if (compareMap(tCount, subStrMap) && subString.length() < minLength) {
                        result = subString;
                        minLength = subString.length();
                    }
                    left++;
                }
            }
        }

        return result;
    }

    public boolean compareMap(Map<Character, Integer> tMap, Map<Character, Integer> subStrMap) {
        for (Character c : tMap.keySet()) {
            if (!subStrMap.containsKey(c) || tMap.get(c) > subStrMap.get(c))
                return false;
        }

        return true;
    }

}
