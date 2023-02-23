package org.codingtest.level0.p120829;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Tests {
    @Test
    @DisplayName("70을 넣으면 1")
    void t1() {
        assertThat(new Solution().solution(70)).isEqualTo(1);
    }

    @Test
    @DisplayName("91을 넣으면 3")
    void t2() {
        assertThat(new Solution().solution(91)).isEqualTo(3);
    }

    @Test
    @DisplayName("180을 넣으면 4")
    void t3() {
        assertThat(new Solution().solution(180)).isEqualTo(4);
    }

    @Test
    @DisplayName("92를 넣으면 3")
    void t4() {
        assertThat(new Solution().solution(92)).isEqualTo(3);
    }

    @Test
    @DisplayName("90을 넣으면 2")
    void t5() {
        assertThat(new Solution().solution(90)).isEqualTo(2);
    }
}
