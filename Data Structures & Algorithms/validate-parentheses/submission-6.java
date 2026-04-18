class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                bracketStack.push(c);
            } else {
                if(bracketStack.isEmpty())
                    return false;
                
                char popChar = bracketStack.pop();
                System.out.print(popChar);
                if((c == ')' && popChar != '(')
                || (c == '}' && popChar != '{')
                || (c == ']' && popChar != '['))
                    return false;
            }
        }

        return bracketStack.isEmpty();
    }
}
