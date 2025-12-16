package y25.level1;

import java.util.*;

public class P42579 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P42579().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> genresCountMap = new HashMap<>();
        Map<String, Queue<Music>> genreMusicQMap = new HashMap<>();
        Queue<Genre> genrePQ = new PriorityQueue<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            genresCountMap.put(genre, genresCountMap.getOrDefault(genre, 0) + playCount);
            if (!genreMusicQMap.containsKey(genre)) {
                genreMusicQMap.put(genre, new PriorityQueue<>());
            }
            genreMusicQMap.get(genre).offer(new Music(i, playCount));
        }

        for (String genre : genresCountMap.keySet()) {
            genrePQ.offer(new Genre(genre, genresCountMap.get(genre)));
        }

        while (!genrePQ.isEmpty()) {
            Genre genre = genrePQ.poll();
            Queue<Music> pq = genreMusicQMap.get(genre.genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                answer.add(pq.poll().index);
                count++;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class Music implements Comparable<Music> {
        int index;
        int playCount;

        public Music(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Music m) {
            if (this.playCount == m.playCount) {
                return this.index - m.index;
            }
            return m.playCount - this.playCount;
        }
    }

    private static class Genre implements Comparable<Genre> {
        String genre;
        int playCount;

        public Genre(String genre, int playCount) {
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Genre g) {
            return g.playCount - this.playCount;
        }
    }
}
