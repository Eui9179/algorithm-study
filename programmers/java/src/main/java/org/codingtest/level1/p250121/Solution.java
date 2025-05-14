package org.codingtest.level1.p250121;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain");
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> dataList = new ArrayList<>();

        for (int[] d : data) {
            if (d[Data.from(ext).index] < val_ext) {
                dataList.add(d);
            }
        }

        dataList.sort(Comparator.comparingInt(d -> d[Data.from(sort_by).index]));

        int[][] answer = new int[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = dataList.get(i);
        }

        return answer;
    }

    enum Data {
        CODE(0, "code"),
        DATE(1, "date"),
        MAXIMUM(2, "maximum"),
        REMAIN(3, "remain");

        final int index;
        final String name;

        Data(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static Data from(String name) {
            return Arrays.stream(Data.values())
                    .filter(d -> d.name.equals(name))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
