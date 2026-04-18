class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                brackStack.push(s.charAt(i));
            else {
                if(brackStack.isEmpty()) return false;
                char popChar = brackStack.pop();
                if((s.charAt(i) == ']' && popChar != '[') || (s.charAt(i) == '}' && popChar != '{') || (s.charAt(i) == ')' && popChar != '('))
                    return false;
            }
        }

        return brackStack.isEmpty();
    }
}
