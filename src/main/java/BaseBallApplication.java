import baseBall.Game;
import baseBall.Replay;


public class BaseBallApplication {
    public static void main(String[] args) {
        Game game = new Game();
        Replay replay = new Replay();
        boolean replayStatus = true;

        while (replayStatus) {
            game.gameStart();
            replayStatus = replay.replayGame();
        }
    }
}