package org.codingtest.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class P120583Test {
    @Test
    @DisplayName("리스트 중복 확인")
    void t1() {
        assertThat(new Solution().solution(new int[]{1, 2, 1, 3, 2, 4, 5, 4}, 2)).isEqualTo(2);
    }
}
