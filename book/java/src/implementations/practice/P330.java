package implementations.practice;

import java.util.*;

public class P330 {
    public int[][] solution(int n, int[][] build_frame) {
        List<Material> mList = new ArrayList<>();
        Material material;
        int x, y, a, b;
        for (int[] build : build_frame) {
            x = build[0];
            y = build[1];
            a = build[2];
            b = build[3];

            material = new Material(x, y, a);

            if (b == 1) { //설치
                mList.add(material);
                if (!isPossible(mList)) {
                    mList.remove(material);
                }
            } else { //삭제
                mList.remove(material);
                if (!isPossible(mList)) {
                    mList.add(material);
                }
            }
        }
        Collections.sort(mList);

        int[][] answer = new int[mList.size()][3];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 3; j++) {
                answer[i][0] = mList.get(i).x;
                answer[i][1] = mList.get(i).y;
                answer[i][2] = mList.get(i).kinds;
            }
        }
        return answer;
    }

    public static boolean isPossible(List<Material> list) {
        int x, y;
        for (Material material : list) {
            x = material.x;
            y = material.y;

            if (material.kinds == 0) {
                if (material.y == 0 || //바닥
                        list.contains(new Material(x, y - 1, 0)) || //또 다른 기둥 위
                        list.contains(new Material(x - 1, y, 1)) || // 보 끝
                        list.contains(new Material(x, y , 1))) { //보 끝
                    continue;
                }
                return false;
            } else {
                if ((list.contains(new Material(x - 1, y, 1))  //
                        && list.contains(new Material(x + 1, y, 1))) ||
                        list.contains(new Material(x, y - 1, 0)) ||
                        list.contains(new Material(x + 1, y - 1, 0))
                ) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    static class Material implements Comparable{
        int x;
        int y;
        int kinds;

        public Material(int x, int y, int kinds) {
            this.x = x;
            this.y = y;
            this.kinds = kinds;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + ", " + kinds + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Material) {
                Material m = (Material) obj;
                if (this.x == m.x && this.y == m.y && this.kinds == m.kinds) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Object o) {
            Material material = (Material) o;
            if (this.x != material.x) {
                return this.x - material.x;
            } else if (this.y != material.y) {
                return this.y - material.y;
            } else {
                return this.kinds - material.kinds;
            }
        }
    }

    public static void main(String[] args) {
        int[][] bf = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };
//        int[][] bf = {
//                {0, 0, 0, 1},
//                {2, 0, 0, 1},
//                {4, 0, 0, 1},
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {2, 1, 1, 1},
//                {3, 1, 1, 1},
//                {2, 0, 0, 0},
//                {1, 1, 1, 0},
//                {2, 2, 0, 1}
//        };

        System.out.println(new P330().solution(5, bf));

    }
}