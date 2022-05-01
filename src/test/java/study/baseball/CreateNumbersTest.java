package study.baseball;

import baseBall.CreateNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNumbersTest {

    CreateNumbers createNumbers = new CreateNumbers();

    @Test
    void 랜덤으로_3가지값을갖는_컴퓨터_수를_생성합니다() {
        List<Integer> computerNumbers = createNumbers.createComputerNumbers();
        assertThat(computerNumbers.stream().distinct().count()).isEqualTo(3);
    }

    @Test
    void input값을_받아서_내_수를_생성합니다() {
        List<Integer> myNumbers = createNumbers.createMyNumbers("123");
        assertThat(myNumbers.size()).isEqualTo(3);
    }
}
