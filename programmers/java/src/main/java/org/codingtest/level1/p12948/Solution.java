package org.codingtest.level1.p12948;

class Solution {
    public String solution(String phone_number) {
        return phone_number
                .replace(phone_number.substring(0, phone_number.length() - 4),
                        "*".repeat(phone_number.length() - 4));
    }
}
