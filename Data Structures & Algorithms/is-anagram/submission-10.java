class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = sortString(s);
        char[] tArr = sortString(t);
        return Arrays.equals(sArr, tArr);
    }

    private char[] sortString(String inputString) {
        char[] sortArray = inputString.toCharArray();
        Arrays.sort(sortArray);
        return sortArray;
    }
}
