package org.codingtest.level0.p120898;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Tests {
    @Test
    @DisplayName("happy birthday!를 넣으면 30")
    void t1() {
        assertThat(new Solution().solution("happy birthday!")).isEqualTo(30);
    }

    @Test
    @DisplayName("i love you~를 넣으면 22")
    void t2() {
        assertThat(new Solution().solution("I love you~")).isEqualTo(22);
    }

    @Test
    @DisplayName("hello를 넣으면 10")
    void t3() {
        assertThat(new Solution().solution("hello")).isEqualTo(10);
    }

    @Test
    @DisplayName("feel so good")
    void t4() {
        assertThat(new Solution().solution("feel so good")).isEqualTo(24);
    }

}