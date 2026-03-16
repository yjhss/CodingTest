import java.util.*;
class Solution {
    String[] ans;
    boolean[] v;
    boolean ok = false;

    public String[] solution(String[][] tickets) {
        // 알파벳 순 정렬
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        
        ans = new String[tickets.length + 1];
        v = new boolean[tickets.length];
        ans[0] = "ICN"; // 시작점 고정
        
        dfs("ICN", 1, tickets);
        return ans;
    }

    void dfs(String cur, int idx, String[][] tickets) {
        if (idx == tickets.length + 1) { // 모든 티켓 사용 완료
            ok = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!v[i] && tickets[i][0].equals(cur)) {
                v[i] = true;         // 티켓 사용
                ans[idx] = tickets[i][1];  // 경로 기록
                
                dfs(tickets[i][1], idx + 1, tickets);
                
                if (ok) return;      // 정답 찾았으면 즉시 종료
                v[i] = false;        // 백트래킹 (티켓 복구)
            }
        }
    }
}