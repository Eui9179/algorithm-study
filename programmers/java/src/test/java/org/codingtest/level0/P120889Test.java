package org.codingtest.level0;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class P120889Test {
    @Test
    @DisplayName("삼각형의 조건")
    void t1() {
        Assertions.assertThat(
                new P120889().solution(new int[]{1, 2, 3})
        ).isEqualTo(2);
    }
}