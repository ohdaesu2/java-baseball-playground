package baseBall;

import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Replay {

    public boolean replayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        char c = scanner.nextLine().charAt(0);
        if (c == '1'){
            return true;
        }
        return false;
    }
}
