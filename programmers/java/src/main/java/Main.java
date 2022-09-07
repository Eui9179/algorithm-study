import level1.P92334;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        P92334 p92334 = new P92334();
        int[] result = p92334.solution(idList, report, 2);
        System.out.println(Arrays.toString(result));
    }
}
