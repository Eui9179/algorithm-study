import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                //인덱스 1부터 시작이라고 가정
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0}
        };

        Map<Integer, List<Integer>> list = Map.of(
                1, List.of(2, 3),
                2, List.of(1, 4),
                3, List.of(1),
                4, List.of(2)

        );
    }
}



