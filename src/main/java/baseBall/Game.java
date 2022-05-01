package baseBall;

import java.util.List;
import java.util.Scanner;

public class Game {

    CreateNumbers createNumbers = new CreateNumbers();
    CompareNumbers compareNumbers = new CompareNumbers();

    public void gameStart(){
        boolean gameStatus = true;
        /*
        컴퓨터  수 생성
         */
        List<Integer> computerNumbers = createNumbers.createComputerNumbers();
        System.out.println("computerNumbers: " + computerNumbers);
        while (gameStatus){
            /*
            내 수 생성
             */
            System.out.println("숫자를 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            String inputValue = scanner.nextLine();
            List<Integer> myNumbers = createNumbers.createMyNumbers(inputValue);
            System.out.println("myNumbers: " + myNumbers);

            /*
            결과 확인하기
             */
            String resultStatus = compareNumbers.compareTwoNumbers(computerNumbers, myNumbers);
            System.out.println(resultStatus);

            gameStatus = gameEnd(resultStatus);
        }
    }

    private boolean gameEnd(String resultState) {
        if(resultState.equals("3스트라이크")){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }
}
