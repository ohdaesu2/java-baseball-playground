package study.baseball;

import baseBall.CompareNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareNumbersTest {
    CompareNumbers compareNumbers = new CompareNumbers();

    List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
    List<Integer> myNumbers = Arrays.asList(1, 3, 4);

    @Test
    void 스트라이크_수를_확인합니다() {;
        int strikeCount = compareNumbers.countStrike(computerNumbers, myNumbers);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 중복_수를_확인합니다() {
        int duplicationCount = compareNumbers.countDuplicationNumber(computerNumbers, myNumbers);
        assertThat(duplicationCount).isEqualTo(2);
    }

    @Test
    void 비교결과를_확인합니다() {
        String resultStatus = compareNumbers.compareTwoNumbers(computerNumbers, myNumbers);
        assertThat(resultStatus).isEqualTo("1스트라이크 1볼");

    }
}
