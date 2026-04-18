class Solution {
    List<String> result = new ArrayList<>();
    Map<Integer, String> digitNumberMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        initalizeMap();
        combinations(digits, 0, "");
        return result;
    }

    public void initalizeMap() {
        digitNumberMap.put(1, null);
        digitNumberMap.put(2, "abc");
        digitNumberMap.put(3, "def");
        digitNumberMap.put(4, "ghi");
        digitNumberMap.put(5, "jkl");
        digitNumberMap.put(6, "mno");
        digitNumberMap.put(7, "pqrs");
        digitNumberMap.put(8, "tuv");
        digitNumberMap.put(9, "wxyz");
    }

    public void combinations(String digits, int start, String res) {
        if(digits.length() == 0)
            return;
        if(start >= digits.length()) {
            result.add(res);
            return;
        }

        String digitChar = digitNumberMap.get(digits.charAt(start) - '0');
        for(char ch : digitChar.toCharArray()) {
            combinations(digits, start + 1, res + ch);
        }
    }


}
