package y25.level1;

public class P161990 {
    public int[] solution(String[] wallpaper) {

        String[][] map = new String[wallpaper.length][];

        for (int i = 0; i < wallpaper.length; i++) {
            map[i] = wallpaper[i].split("");
        }

        // 위쪽: x1
        // 왼쪽: y1

        // 아래쪽: x2
        // 오른쪽: y2

        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("#")) {
                    x1 = Math.min(i, x1);
                    y1 = Math.min(j, y1);
                    x2 = Math.max(i, x2);
                    y2 = Math.max(j, y2);
                }
            }
        }

        return new int[]{x1, y1, x2 + 1, y2 + 1};
    }
}
