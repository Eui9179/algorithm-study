package org.codingtest.level0.p120889;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Tests {
    @Test
    @DisplayName("삼각형의 조건")
    void t1() {
        Assertions.assertThat(
                new Solution().solution(new int[]{1, 2, 3})
        ).isEqualTo(2);
    }
}