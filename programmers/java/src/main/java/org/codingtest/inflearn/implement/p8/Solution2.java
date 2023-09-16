package org.codingtest.inflearn.implement.p8;

import java.util.*;
class Solution2 {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        int enterIdx = 0;

        int[] answer = new int[n];
        List<Integer> timeLine = new ArrayList<>();

        for (int exitPerson : exit) {
            if (timeLine.contains(exitPerson)) {
                timeLine.add(exitPerson);
                continue;
            }
            while (enterIdx < n) {
                int enterPerson = enter[enterIdx];
                timeLine.add(enterPerson);
                enterIdx++;
                if (exitPerson == enterPerson) {
                    break;
                }
            }
            timeLine.add(exitPerson);
        }

        updateMeetCount(answer, timeLine);
        return answer;
    }

    private void updateMeetCount(int[] answer, List<Integer> timeLine) {
        Set<Integer> complete = new HashSet<>();

        for (int i = 0; i < timeLine.size() - 1; i++) {
            Set<Integer> met = new HashSet<>();
            int currentPerson = timeLine.get(i);

            if (complete.contains(currentPerson)) continue;
            complete.add(currentPerson);

            for (int j = i + 1; j < timeLine.size(); j++) {
                if (timeLine.get(j) == currentPerson) break;
                if (met.contains(timeLine.get(j)) || complete.contains(timeLine.get(j))) continue;
                met.add(timeLine.get(j));
                answer[timeLine.get(j) - 1]++;
            }
            answer[currentPerson - 1] += met.size();
        }
    }

    public static void main(String[] args){
        Solution2 T = new Solution2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
