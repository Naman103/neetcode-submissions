class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String s : strs)
            encodedString += s.length() + "#" + s;
        return encodedString;
    }

    public List<String> decode(String str) {
        System.out.print(str);
        List<String> result = new ArrayList<>();
        int i = 0;
        String lengthSubString = "";
        while( i < str.length()) {
            if(str.charAt(i) != '#') {
                lengthSubString += str.charAt(i);
                i++;
            } else {
                String subString = str.substring(i + 1, i + 1 + Integer.valueOf(lengthSubString));
                result.add(subString);
                i += 1 + Integer.valueOf(lengthSubString);
                lengthSubString = "";
            }
        }

        return result;      
    }
}
