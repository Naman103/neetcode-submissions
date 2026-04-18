class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String  s : strs) {
            encodedString += s.length() + "#" + s;
        }

        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String strLength = "";
        int i = 0;
        while(i < str.length()) {
            char c = str.charAt(i);
            if(c == '#') {
                int length = Integer.parseInt(strLength);
                String res = str.substring(i + 1, i + 1 +length);
                result.add(res);
                i = i + 1 + length;
                strLength = "";
            } else {
                strLength += c;
                i++;
            }        
        }

        return result;
    }
}
