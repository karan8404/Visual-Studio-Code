public class problem14 {
    // longest common prefix.
    public String longestCommonPrefix(String[] strs) {
        StringBuffer pre = new StringBuffer(strs[0]);
        for (String st : strs) {
            for (int i = 0; i < pre.length(); i++) {
                if (st.length()==i || st.charAt(i) != pre.charAt(i)){
                    pre.delete(i, pre.length());
                    break;
                }
            }
        }

        return pre.toString();
    }
}
