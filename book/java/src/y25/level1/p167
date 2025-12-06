package y25.binarysearch;

import java.util.*;

public class P372 {
    public static void main(String[] args) {
        solution(new ArrayList<>(List.of("frodo", "front", "frost", "frozen", "frame", "kakao")),
                List.of("fro??", "????o", "fr???", "fro???", "pro?"));
    }

    private static void solution(List<String> words, List<String> queries) {
        List<Integer> result = new ArrayList<>();

        // 1. 길이 순, 스트링 사전순으로 정렬
        // 2. 시작 위치 찾음?
        // 3. 끝 위치 찾음?
        words.sort((w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            }
            return w1.length() - w2.length();
        });

        Map<Integer, List<String>> wordLengthMap = new HashMap<>();
        for (String word : words) {
            if (!wordLengthMap.containsKey(word.length())) {
                wordLengthMap.put(word.length(), new ArrayList<>());
            }
            wordLengthMap.get(word.length()).add(word);
        }

        for (String query : queries) {
            if (!wordLengthMap.containsKey(query.length())) {
                System.out.println("Not exsit");
                continue;
            }
            for (String word : wordLengthMap.get(query.length())) {
                System.out.println("word = " + word);
                System.out.println("query = " + query);
                System.out.println(compareWord(word, query));
            }
        }
    }

    private static int binarySearch(List<String> words, String search) {
        int start = 0;
        int end = words.size();

        while (start >= end) {
            int mid = (start + end) / 2;
//            if ()
            start++;
        }
        return 0;
    }

    private static int compareWord(String word, String query) {
        for (int i = 0; i < word.length(); i++) {
            if (query.charAt(i) == '?') {
                continue;
            } else if (word.charAt(i) != query.charAt(i)) {
                return word.compareTo(query);
            }
        }
        return 0;
    }
}
