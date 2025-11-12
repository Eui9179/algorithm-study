package y25.level1;

public class P161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int sectionIndex = 0;
        while (sectionIndex < section.length) {
            int start = section[sectionIndex];
            while (sectionIndex < section.length &&
                    section[sectionIndex] <= start + (m - 1)) {
                sectionIndex++;
            }
            answer++;
        }

        return answer;
    }
}
