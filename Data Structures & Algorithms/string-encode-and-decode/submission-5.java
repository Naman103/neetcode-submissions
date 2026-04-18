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
       String sLength = "";
       int i = 0;
       while(i < str.length()) {
             if(str.charAt(i) != '#') {
                sLength += str.charAt(i);
                i++;
             } else {
                int strLength = Integer.parseInt(sLength);
                result.add(str.substring(i + 1, i + 1 + strLength));
                sLength = "";
                i += strLength + 1;
             }
       }

       return result;
    }
}
