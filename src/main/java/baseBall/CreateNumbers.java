package baseBall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateNumbers {
    /*
    상대방(컴퓨터) 수 생성
     */
    public List<Integer> createComputerNumbers() {
        List<Integer> randomThreeNumbers = new ArrayList<>();
        while (randomThreeNumbers.size() < 3) {
            checkAndAddValueInList(randomThreeNumbers, createRandomNumber());
        }
        return randomThreeNumbers;
    }
    /*
    내 수 생성
     */
    public List<Integer> createMyNumbers(String input) {
        List<Integer> myNumbers = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            myNumbers.add(charToInt(input.charAt(i)));
        }
        return myNumbers;
    }

    private int charToInt(char c) {
        return c - '0';
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    private List<Integer> checkAndAddValueInList(List<Integer> numberList, int value) {
        if (!(numberList.contains(value))) {
            numberList.add(value);
        }
        return numberList;
    }
}
