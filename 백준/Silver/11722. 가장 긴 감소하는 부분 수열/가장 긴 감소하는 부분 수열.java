import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] A = new int[N];
        int[] dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // 모든 원소는 최소한 자기 자신 하나로 이루어진 길이 1의 수열임
            dp[i] = 1; 
        }
        
        int maxLen = 1;
        
        // DP 진행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 앞의 원소(A[j])가 현재 원소(A[i])보다 크면 감소 관계 형성
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 전체 수열 중 최댓값 갱신
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        System.out.println(maxLen);
    }
}