class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String some : strs) {
            s.append(some.length()).append('#').append(some);
        }

        return s.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#')
                j++;
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }

        return result;
    }
}
