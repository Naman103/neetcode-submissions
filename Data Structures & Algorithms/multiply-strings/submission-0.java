class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        if (num1.length() < num2.length())
            return multiply(num2, num1);
        
        int i = num2.length() - 1;
        int zero = 0;
        String res = "";
        while (i >= 0) {
            String cur = multiply(num1, num2.charAt(i), zero);
            res = add(res, cur);
            zero++;
            i--;
        }

        return res;
    }

    private String multiply(String num, char d, int zero) {
        int i = num.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || carry > 0) {
            int n1 = i >= 0 ? num.charAt(i) - '0' : 0;
            int digit = d - '0';
            int total = n1 * digit + carry;
            res.append(total % 10);
            carry = total/10;
            i--;
        }

        return res.reverse().toString() + "0".repeat(zero);
    }

    // multiplying single digit and adding all numbers

    private String add(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int total = n1 + n2 + carry;
            res.append(total % 10);
            carry = total/10;
            i--;
            j--;
        }

        return res.reverse().toString();
    }
}

