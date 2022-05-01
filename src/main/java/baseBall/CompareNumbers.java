package baseBall;

import java.util.List;

public class CompareNumbers {
    /*
    두 수 비교
    */
    public String compareTwoNumbers(List<Integer> computerNumbers, List<Integer> myNumbers) {
        int duplication = countDuplicationNumber(computerNumbers, myNumbers);
        int strike = countStrike(computerNumbers, myNumbers);
        int ball = countBall(duplication, strike);

        if (duplication == 0) {
            return "낫싱";
        }
        return getResultStatus(strike, ball);
    }

    private String getResultStatus(int strike, int ball) {
        if (strike == 0 || ball ==0){
            return ballOrStrikeIsZero(strike, ball);
        }
        return strike + "스트라이크" + " " + ball + "볼";
    }
    /*
    함수명이 제대로 된게 생각이 안나서...
     */
    private String ballOrStrikeIsZero(int strike, int ball) {
        if (strike == 0) {
            return ball + "볼";
        }
        return strike + "스트라이크";
    }

    public int countDuplicationNumber(List<Integer> computerNumbers, List<Integer> myNumbers) {
        int result = 0;
        for (int i=0; i<computerNumbers.size(); i++) {
            result += checkDuplication(computerNumbers, myNumbers, i);
        }
        return result;
    }

    private int checkDuplication(List<Integer> computerNumbers, List<Integer> myNumbers, int i) {
        int duplication = 0;
        if (computerNumbers.contains(myNumbers.get(i))) {
            duplication = 1;
        }
        return duplication;
    }

    public int countStrike(List<Integer> computerNumbers, List<Integer> myNumbers) {
        int result = 0;
        for(int i=0; i < computerNumbers.size(); i++){
            result += checkStrike(computerNumbers, myNumbers, i);
        }
        return result;
    }

    private int checkStrike(List<Integer> computerNumbers, List<Integer> myNumbers, int i) {
        int strike = 0;
        if (computerNumbers.get(i) == myNumbers.get(i)) {
            strike = 1;
        }
        return strike;
    }

    private int countBall(int duplication, int strike) {
        return duplication - strike;
    }
}
