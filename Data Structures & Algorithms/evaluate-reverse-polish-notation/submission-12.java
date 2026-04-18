class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> resultStack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");

        for(String token : tokens) {
            if(operators.contains(token)) {
                int firstNumber = resultStack.pop();
                int secondNumber = resultStack.pop();

                if(token.equals("+"))
                    resultStack.push(firstNumber + secondNumber);
                else if (token.equals("-"))
                    resultStack.push(secondNumber - firstNumber);
                else if (token.equals("*"))
                    resultStack.push(secondNumber * firstNumber);
                else
                    resultStack.push(secondNumber/firstNumber);

            } else {
                resultStack.push(Integer.valueOf(token));
            }
        }

        return resultStack.pop();
    }
}
