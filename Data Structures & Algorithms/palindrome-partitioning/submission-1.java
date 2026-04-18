class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partition(0, s, new ArrayList<>());
        return result;
    }

    private void partition(int pos, String s, List<String> parts) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(parts));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isPallindrome(s, pos, i)) {
                parts.add(s.substring(pos, i + 1));
                partition(i + 1, s, parts);
                parts.remove(parts.size() - 1);
            }
        }

    }

    private boolean isPallindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
