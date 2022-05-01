package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1_1() {
        String string = "1,2";
        String[] stringArray = string.split(",");
        assertThat(stringArray).contains("1");
        assertThat(stringArray).contains("2");
        assertThat(stringArray).containsExactly("1","2");
    }

    @Test
    void test1_2() {
        String string = "(1,2)";
        String result = string.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("스트링에 대한 학습 테스트 요구사항 3")
    void test1_3() throws Exception {
        String string = "abc";
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> StringIndexOutOfBoundsException())
                .hasMessage("위치 값을 벗어났습니다.");

    }

    private void StringIndexOutOfBoundsException() throws Exception {
        throw new Exception("위치 값을 벗어났습니다.");
    }
}
