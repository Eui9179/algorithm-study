package y25.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P360 {
    public static void main(String[] args) {
        solution(new Object[][]{
                {"J", 50, 60, 100},
                {"S", 80, 60, 50},
                {"S2", 80, 70, 100},
                {"D", 80, 60, 100}

        });
    }

    private static void solution(Object[][] students) {
        List<Student> studentList = new ArrayList<>();
        for (Object[] student : students) {
            String name = (String) student[0];
            int kor = (Integer) student[1];
            int eng = (Integer) student[2];
            int math = (Integer) student[3];
            studentList.add(new Student(name, kor, eng, math));
        }
        Collections.sort(studentList);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    private static class Student implements Comparable<Student> {
        private String name;
        private int kor;
        private int eng;
        private int math;

        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student student) {
            if (this.kor != student.kor) {
                return student.kor - this.kor;
            } else if (this.eng != student.eng) {
                return this.eng - student.eng;
            } else if (this.math != student.math) {
                return student.math - this.math;
            } else {
                return this.name.compareTo(student.name);
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    '}';
        }
    }

}
