package y25.level1;
import java.util.*;

public class P77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        List<Integer> winSet = new ArrayList<>();

        for (int num : win_nums) {
            winSet.add(num);
        }

        for (int lotto: lottos) {
            winSet.remove(Integer.valueOf(lotto));
            if (lotto == 0) {
                zeroCount++;
            }
        }

        int row = winSet.size() != 6 ? winSet.size() + 1 : winSet.size();

        if (zeroCount > 0) {
            winSet.subList(0, zeroCount).clear();
        }

        int high = winSet.size() == 6 ? 6 : 7 - (6 - winSet.size());

        return new int[]{high, row};
    }
}
