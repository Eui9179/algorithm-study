package test.test3;

import java.util.*;

public class Solution {
    public int[] solution(String[][] folders, String[][] files, String[] selected, String[] excepted) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> fileInfo = new HashMap<>();
        List<String> stack = new ArrayList<>(List.of(selected));
        List<String> visited = new ArrayList<>(List.of(excepted));

        String filename;
        String volumn;

        int totalVolumn = 0;
        int totalCount = 0;

        for (String[] folder : folders) {
            if (graph.containsKey(folder[1])) {
                graph.get(folder[1]).add(folder[0]);
            } else {
                graph.put(folder[1], new ArrayList<>(List.of(folder[0])));
            }
        }


        for (String[] file : files) {
            filename = file[0];
            volumn = file[1];

            fileInfo.put(filename, changeByteToInt(volumn));

            if (graph.containsKey(file[2])) {
                graph.get(file[2]).add(filename);
            } else {
                graph.put(file[2], new ArrayList<>(List.of(filename)));
            }
        }

        while (stack.size() > 0) {
            String now = stack.remove(0);

            if (visited.contains(now)) {
                continue;
            }

            visited.add(now);

            if (fileInfo.containsKey(now)) {
                //파일이면?
                totalVolumn += fileInfo.get(now);
                totalCount += 1;
            }

            if (graph.containsKey(now)) {
                for (String node : graph.get(now)) {
                    stack.add(0, node);
                }
            }

        }
        return new int[]{totalVolumn, totalCount};
    }

    public int changeByteToInt(String b) {
        if (!b.contains("KB")) {
            return Integer.parseInt(b.substring(0, b.length() - 1));
        }
        return Integer.parseInt(b.substring(0, b.length() - 2)) * 1024;
    }

    public static void main(String[] args) {
        String[][] folders = {
                {"food", "root"},
                {"meat", "food"},
                {"fruit", "food"},
                {"animal", "root"}
        };
        String[][] files = {
                {"cat", "1B", "animal"},
                {"dog", "2B", "animal"},
                {"fork", "1KB", "meat"},
                {"beef", "8KB", "meat"},
                {"apple", "4B", "fruit"},
                {"fire", "83B", "root"},
        };

        String[] selected = {"root", "meat"};
        String[] excepted = {"fork", "apple"};
        int[] solution = new Solution().solution(folders, files, selected, excepted);
        System.out.println(solution[0] + " " + solution[1]);
    }

}
