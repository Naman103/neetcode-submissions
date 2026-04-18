class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                bracketStack.push(c);
            else {
                if(bracketStack.isEmpty())
                    return false;
                char popCharacter = bracketStack.pop();
                if(!(
                    (popCharacter == '(' && c == ')')
                    || (popCharacter == '{' && c == '}')
                    ||(popCharacter == '[' && c == ']')))
                    return false;
                
            }
        }

        return bracketStack.isEmpty();
    }
}
