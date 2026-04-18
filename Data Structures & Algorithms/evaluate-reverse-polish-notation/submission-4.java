class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        List<String> operatorList = List.of("+", "-", "*", "/");
        for(String s : tokens) {
            if(operatorList.contains(s)) {
                int firstValue =numberStack.pop(), secondValue = numberStack.pop();
                if(s.equals("+")) {
                    numberStack.push(firstValue + secondValue);
                    System.out.println(firstValue + secondValue);
                } else if (s.equals("-")) {
                    numberStack.push(secondValue - firstValue);
                    System.out.println(secondValue - firstValue);
                } else if (s.equals("*")) {
                    numberStack.push(secondValue * firstValue);
                    System.out.println(firstValue * secondValue);
                } else if (s.equals("/")) {
                    if(firstValue == 0) {
                        numberStack.push(0);
                        System.out.println(0);
                    }
                    else {
                        numberStack.push(secondValue/ firstValue);
                        System.out.println(secondValue/ firstValue);
                    }
                }

            } else {
                numberStack.push(Integer.parseInt(s));
            }
        }

        return numberStack.pop();
    }
}
