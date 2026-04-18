class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String s : strs) {
            encodedString.append(s.length()).append('#').append(s);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedResult = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#')
                j++;
            int strLength = Integer.parseInt(str.substring(i, j));
            j += 1;
            String decodedString = str.substring(j, j + strLength);
            decodedResult.add(decodedString);
            i = j + strLength;
        }

        return decodedResult;
    }
}
