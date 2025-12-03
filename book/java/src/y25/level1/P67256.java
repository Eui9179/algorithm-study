package y25.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        CurrentButton lIndex = new CurrentButton(3, -1, "left");
        CurrentButton rIndex = new CurrentButton(3, -1, "right");

        List<Integer> leftNumbers = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> centerNumbers = new ArrayList<>(Arrays.asList(2, 5, 8, 0));
        List<Integer> rightNumbers = new ArrayList<>(Arrays.asList(3, 6, 9));

        for (int number: numbers) {
            if (leftNumbers.contains(number)) {
                answer += "L";
                lIndex.setPosition(
                        leftNumbers.indexOf(Integer.valueOf(number)),
                        number,
                        "left"
                );
            } else if (rightNumbers.contains(number)) {
                answer += "R";
                rIndex.setPosition(
                        rightNumbers.indexOf(Integer.valueOf(number)),
                        number,
                        "right"
                );
            } else {
                int numberIndex = centerNumbers.indexOf(Integer.valueOf(number));
                // 손가락이 다른 자판에 있는지 확인
                // 다른 자판이라면 같은 인덱스라도 + 1
                int lDistance = Math.abs(lIndex.index - numberIndex);
                int rDistance = Math.abs(rIndex.index - numberIndex);

                if ("left".equals(lIndex.group)) lDistance++;
                if ("right".equals(rIndex.group)) rDistance++;

                if (lDistance < rDistance) {
                    answer += "L";
                    lIndex.setPosition(
                            centerNumbers.indexOf(Integer.valueOf(number)),
                            number,
                            "center"
                    );
                } else if (rDistance < lDistance) {
                    answer += "R";
                    rIndex.setPosition(
                            centerNumbers.indexOf(Integer.valueOf(number)),
                            number,
                            "center"
                    );
                } else {
                    if ("right".equals(hand)) {
                        rIndex.setPosition(
                                centerNumbers.indexOf(Integer.valueOf(number)),
                                number,
                                "center"
                        );
                    }
                    else {
                        lIndex.setPosition(
                                centerNumbers.indexOf(Integer.valueOf(number)),
                                number,
                                "center"
                        );
                    }
                    answer += hand.toUpperCase().charAt(0);

                }
            }
        }

        return answer;
    }

    static class CurrentButton {
        int index;
        int value;
        String group;

        CurrentButton(int index, int value, String group) {
            this.index = index;
            this.value = value;
            this.group = group;
        }

        void setPosition(int index, int value, String group) {
            this.index = index;
            this.value = value;
            this.group = group;
        }

    }
}
