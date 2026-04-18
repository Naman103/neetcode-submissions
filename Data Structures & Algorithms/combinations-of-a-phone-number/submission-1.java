class Solution {
    List<String> result;
    Map<Character, String> digitCharMap; 

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        this.initializeMap();
        letterCombinations(digits, 0, "");
        return result;
    }

    private void letterCombinations(String digits, int currentPosition, String res) {
        if (digits.length() == 0)
            return;
        
        if (currentPosition == digits.length()) {
            result.add(res);
            return;
        }

        String digitChar = digitCharMap.get(digits.charAt(currentPosition));
        for (char c : digitChar.toCharArray())
            letterCombinations(digits, currentPosition + 1, res + c);
    }


    private void initializeMap() { 
        digitCharMap = new HashMap<>();
        digitCharMap.put('2', "abc");
        digitCharMap.put('3', "def");
        digitCharMap.put('4', "ghi");
        digitCharMap.put('5', "jkl");
        digitCharMap.put('6', "mno");
        digitCharMap.put('7', "pqrs");
        digitCharMap.put('8', "tuv");
        digitCharMap.put('9', "wxyz");

    }
}
