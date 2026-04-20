import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 이미 가진 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        long[] lines = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            if (max < lines[i]) {
                max = lines[i];
            }
        }

        // 이분 탐색 범위 설정
        // * max에 1을 더해주는 이유: low=0, high=1인 경우 mid가 0이 되어 발생하는 ZeroDivision 예외 방지
        long low = 1;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            // 모든 랜선을 mid 길이로 잘랐을 때 나오는 총 개수 계산
            for (int i = 0; i < K; i++) {
                count += (lines[i] / mid);
            }

            // 개수가 N보다 크거나 같으면, 더 길게 자를 수 있는지 확인
            if (count >= N) {
                result = mid; // 일단 현재 길이를 저장
                low = mid + 1;
            } 
            // 개수가 부족하면 길이를 줄여야 함
            else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}