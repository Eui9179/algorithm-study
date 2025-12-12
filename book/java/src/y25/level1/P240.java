package y25.level1;

import java.util.HashSet;
import java.util.Set;

public class P240 {
    public static void main(String[] args) {

    }

    public boolean solution(int[] arr, int target) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i : arr) {
            numberSet.add(i);
        }

        for (int i : arr) {
            if (numberSet.contains(target - i)) {
                return true;
            }
        }

        return false;
    }
}
