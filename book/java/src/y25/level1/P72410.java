package y25.level1;

public class P72410 {
    public static void main(String[] args) {
        System.out.println(new P72410().solution("ABC.._-!@#"));
        System.out.println(new P72410().solution("...!@BaT#*..y.abcdefghijklm"));
    }
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        System.out.println("step1 = " + step1);
        String step2 = step1.replaceAll("[^a-z0-9._-]", "");
        System.out.println("step2 = " + step2);
        String step3 = step2;
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        System.out.println("step3 = " + step3);
        String step4 = step3.startsWith(".") ? step3.substring(1) : step3;
        step4 = step4.endsWith(".") ? step4.substring(0, step4.length() - 1) : step4;
        System.out.println("step4 = " + step4);
        String step5 = step4.isEmpty() ? "a" : step4;
        System.out.println("step5 = " + step5);
        String step6 = step5.length() > 15 ? step5.substring(0, 15) : step5;
        step6 = step6.endsWith(".") ? step6.substring(0, step6.length() - 1) : step6;
        System.out.println("step6 = " + step6);
        String step7 = step6;
        while (step7.length() < 3) {
            step7 += step7.charAt(step7.length() - 1);
        }
        System.out.println("step7 = " + step7);

        return step7;
    }
}
