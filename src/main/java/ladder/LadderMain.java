package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String playerNames = InputView.inputParticipants();
        String winningPrizes = InputView.inputWinningPrizes();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        InputView.printStartLineOfLadderGame();

        Players players = new Players(playerNames);
        ResultView.printResultPlayer(players);

        ConnectingStrategy connectingStrategy = new RandomConnectingStrategy();
        Ladder ladder = new Ladder(players.countOfPlayers(), maxLadderHeight, connectingStrategy);
        ResultView.printResult(ladder.getVerticalLines());

        Prizes prizes = new Prizes(winningPrizes);
        Players result = prizes.resultPrize(players, ladder);

        for (int i = 0; i < result.countOfPlayers(); i++) {
            String chosen = InputView.inputWhoWantToSeeResult();
            InputView.printResultOfChosenPlayer(getResult(result, chosen));
        }
    }

    private static String getResult(Players result, String chosen) {
        if ("all".equals(chosen)) {
            return ResultView.allPlayerResult(result);
        }
        return result.getPlayers().get(new PlayerName(chosen));
    }
}
