import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if ((int)ch >= 65 &&  (int)ch <= 90)
                System.out.print((char)(ch+32));
            
            else if ((int)ch >= 97 &&  (int)ch <= 122)
                System.out.print((char)(ch-32));
        
        }
    }
}