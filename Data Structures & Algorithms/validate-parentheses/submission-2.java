class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                brackStack.push(c);
            else {
                if(brackStack.isEmpty()) return false;
                char popedChar = brackStack.pop();
                if(!((popedChar == '{' && c == '}')
                || (popedChar == '(' && c == ')')
                || (popedChar == '[' && c == ']')))

                return false;
            }
        }

        return brackStack.isEmpty();
    }
}
