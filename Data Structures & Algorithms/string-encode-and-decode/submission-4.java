class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String s : strs) {
            encodedString += s.length() + "#" + s; 
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        String lengthString = "";
        while(i < str.length()) {
            if(str.charAt(i) == '#') {
                int length = Integer.parseInt(lengthString);
                result.add(str.substring(i + 1, i + 1+ length));
                i = i + 1 + length;
                lengthString = "";
            } else {
                lengthString += str.charAt(i);
                i++;
            }
        }

        return result;
    }
}
