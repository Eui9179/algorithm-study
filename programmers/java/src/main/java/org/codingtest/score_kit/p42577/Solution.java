package org.codingtest.score_kit.p42577;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String p1 = phone_book[i];
            String p2 = phone_book[i + 1];
            if (p2.startsWith(p1) || p1.startsWith(p2)) return false;
        }
        return true;
    }
}