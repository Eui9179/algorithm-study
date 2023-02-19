package implementations.practice;
import java.util.*;
public class Main {
    public static void solution(int[][] map, int n, int m) {
        int result = 0;

        /**
         * 치킨집 전체 중에 m개의 집을 선택하고
         */

        ArrayList<House> houses = new ArrayList<>();
        ArrayList<Chicken> chickens = new ArrayList<>();

        Chicken myChicken = new Chicken();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] == 1) {
                    houses.add(new House(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }

        int minDistance = 0;




//        for (House house : houses) {
//            int minDistance = 100 * n;
//            for (Chicken chicken : chickens) {
//                int distance = Math.abs(house.x - chicken.x)
//                        + Math.abs(house.y - chicken.y);
//                chicken.addDistance(distance);
//                if (distance < minDistance) {
//                    minDistance = distance;
//                    myChicken = chicken;
//                }
//            }
//            myChicken.addHouse(house);
//        }
//
//        Collections.sort(chickens);
//        chickens.forEach(System.out::println);
//
//        for (int i = 0; i < chickens.size(); i++) {
//            Chicken chicken = chickens.get(i);
//            if (i < m) {
//                for (House house : chicken.houses) {
//                    result += Math.abs(chicken.x - house.x)
//                            + Math.abs(chicken.y - house.y);
//                }
//            }
//            else {
//                for (House house : chicken.houses) {
//                    int minDistance = 2 * n;
//                    for (int j = 0; j < m; j++) {
//                        int distance = Math.abs(house.x - chickens.get(j).x)
//                                + Math.abs(house.y - chickens.get(j).y);
//                        if (distance < minDistance) {
//                            minDistance = distance;
//                        }
//                    }
//                    result += minDistance;
//                }
//            }
//        }
//
//        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solution(map, n, m);
    }

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "House{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Chicken implements Comparable<Chicken>{
        int x;
        int y;
        int sumDistances;
        ArrayList<House> houses;

        public Chicken() {
        }

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
            this.sumDistances = 0;
            houses = new ArrayList<>();
        }

        public void addDistance(int distance) {
            this.sumDistances += distance;
        }

        public void addHouse(House house) {
            this.houses.add(house);
        }

        @Override
        public int compareTo(Chicken c) {
            if (this.houses.size() == c.houses.size()) {
                return this.sumDistances - c.sumDistances;
            }
            return c.houses.size() - this.houses.size();
        }

        @Override
        public String toString() {
            return "x= " + this.x + ", y= " + this.y + ", distance= " + this.sumDistances + " "+ houses;
        }
    }
}

