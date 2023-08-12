import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length; // 이용자 수
        int[] answer = new int[n];
        Map<String, Integer> list = new HashMap<>();
        Map<String, HashSet<String>> reporter = new HashMap<>();

        for (int i = 0; i < n; i++) {
            answer[i] = 0;
            list.put(id_list[i], i);
        }

        for (String me : report) {
            String[] mem = me.split("\\s");
            String reportedUser = mem[1];
            String reporterUser = mem[0];

            reporter.putIfAbsent(reportedUser, new HashSet<>());
            reporter.get(reportedUser).add(reporterUser);
        }

        for (String reportedUser : reporter.keySet()) {
            HashSet<String> reporters = reporter.get(reportedUser);
            if (reporters.size() >= k) {
                for (String reporterUser : reporters) {
                    int index = list.get(reporterUser);
                    answer[index]++;
                }
            }
        }

        return answer;
    }
}
