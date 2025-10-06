class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] my = my_string.toCharArray();
        char[] overwrite = overwrite_string.toCharArray();
        
        for (int i = 0; i < overwrite.length; i++)
            my[i+s] = overwrite[i];
        
        return new String(my);
        
    }
}