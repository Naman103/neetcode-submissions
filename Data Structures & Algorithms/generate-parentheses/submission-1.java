class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateBrackets(0, 0, "", n);
        return res;
    }

    public void generateBrackets(int left, int right, String s, int n) {
        if(s.length() == 2 * n && left == right) {
            res.add(s);
            return;
        }

        if(left < n)
            generateBrackets(left + 1, right, s + "(", n);
        
        if(left > right)
            generateBrackets(left, right + 1, s + ")", n);
    }
}
