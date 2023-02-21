/*숫자 카드 게임*/

package greedy.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P96 {
    public static void solution(ArrayList<Integer>[] cards) {
        int answer = -1;
        for (ArrayList<Integer> row : cards) {
            answer = Math.max(Collections.min(row), answer);
        }

        System.out.println("answer = " + answer);
    }
    public static void main(String[] args) {
        ArrayList<Integer>[] cards = new ArrayList[3];
        cards[0] = new ArrayList<>(Arrays.asList(3, 1, 2));
        cards[1] = new ArrayList<>(Arrays.asList(4, 1, 4));
        cards[2] = new ArrayList<>(Arrays.asList(2, 2, 2));

        solution(cards);
    }
}
