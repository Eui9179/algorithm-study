package y25.dijkstra;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Obj> pQ = new PriorityQueue<>();
        pQ.offer(new Obj("1"));
        pQ.offer(new Obj("12"));
        pQ.offer(new Obj("123"));
        pQ.offer(new Obj("1234"));
        pQ.offer(new Obj("12345"));

        while (!pQ.isEmpty()) {
            System.out.println(pQ.poll());
        }

    }


    private static class Obj implements Comparable<Obj> {

        String value;

        Obj(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Obj o) {
            return this.value.length() - o.value.length();
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}


