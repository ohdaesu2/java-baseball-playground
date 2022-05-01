package study;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateTest {

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Test
    void 문자열_계산기() throws Exception{
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");
        int result = calculateString(values);
        assertThat(result).isEqualTo(10);

    }
    // 왜 여기서 throws Exception 을 하지 않아도 작동이 되는건가요?
    @Test
    void 나누는_수가_0일때_오류를_발생합니다() throws Exception{
        String value = "2 / 0";
        String[] values = value.split(" ");
        assertThatThrownBy(() -> {
            calculateString(values);
        }).isInstanceOf(NotExistZeroDivideException.class);
    }

    @Test
    void 연산자가_올바르지_않을때_오류를_발생합니다() throws Exception {
        String value = "2 & 1";
        String[] values = value.split(" ");
        assertThatThrownBy(() -> {
            calculateString(values);
        }).isInstanceOf(NotExistOperateException.class);

    }

    public int calculateString(String[] values) throws Exception {
        int result = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            result = calculate(result, Integer.parseInt(values[i + 2]), values[i + 1].charAt(0));
        }
        return result;
    }

    private int calculate(int firstInt, int secondInt, char operator) throws Exception {
        if(operator == '+')
            return add(firstInt, secondInt);

        if(operator == '-')
            return subtract(firstInt, secondInt);

        if(operator == '*')
            return multiply(firstInt, secondInt);

        if(operator == '/')
            return divide(firstInt, secondInt);
        throw new NotExistOperateException();
    }

    private int add(int a, int b) {
        return a+b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) throws Exception {
        try{
            return a / b;
        } catch (Exception e){
            throw new NotExistZeroDivideException();
        }
    }

    private class NotExistOperateException extends Exception {
        NotExistOperateException() {
            super("연산자가 올바르지 않습니다.");
        }
    }

    private class NotExistZeroDivideException extends Exception {
        NotExistZeroDivideException() {
            super("0으로 나눌 수 없습니다.");
        }
    }
}
