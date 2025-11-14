package y25.level1;

public class P161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int sectionIndex = 0;
        while (sectionIndex < section.length) {
            int start = section[sectionIndex];
            while (isBoundary(sectionIndex, section, start, m)) {
                sectionIndex++;
            }
            answer++;
        }

        return answer;
    }
    private boolean isBoundary(int sectionIndex, int[] section, int start, int m) {
        return sectionIndex < section.length &&
                section[sectionIndex] <= start + (m - 1);
    }
}
