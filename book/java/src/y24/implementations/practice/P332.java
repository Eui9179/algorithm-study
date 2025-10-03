package y24.implementations.practice;
import java.util.*;
public class P332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<House> houses = new ArrayList<>();
        ArrayList<Chicken> chickens = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int data = sc.nextInt();
                if (data == 1) {
                    houses.add(new House(i, j));
                } else if (data == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }

        ArrayList<ArrayList<Chicken>> combResult = new ArrayList<>();
        boolean[] compVisited = new boolean[chickens.size()];
        comb(chickens, combResult, compVisited, 0, m);

        int result = Integer.MAX_VALUE;

        for (ArrayList<Chicken> combination : combResult) {
            result = Math.min(result, sumDistance(houses, combination));
        }
        System.out.println(result);

    }

    static<T> void comb(ArrayList<T> arr, ArrayList<ArrayList<T>> result, boolean[] visited, int depth, int r) {
        if (r == 0) {

            ArrayList<T> combination = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) {
                    combination.add(arr.get(i));
                }
            }
            result.add(combination);
            return;
        }

        if (depth == arr.size()) {
            return;
        }

        visited[depth] = true;
        comb(arr, result, visited, depth + 1, r - 1);

        visited[depth] = false;
        comb(arr, result, visited, depth + 1, r);
    }

    public static int sumDistance(ArrayList<House> houses, ArrayList<Chicken> chickens) {
        int result = 0;
        for (House house : houses) {
            int distance = Integer.MAX_VALUE;
            for (Chicken chicken : chickens) {
                distance = Math.min(distance,
                        Math.abs((chicken.x - house.x)) + Math.abs((chicken.y - house.y)));
            }
            result += distance;
        }
        return result;
    }

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Chicken {
        int x;
        int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
