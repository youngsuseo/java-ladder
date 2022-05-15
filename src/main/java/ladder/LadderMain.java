package ladder;

import ladder.domain.Players;
import ladder.view.InputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.inputParticipants();
        List<String> players = Players.create(names);

        int maxLadderHeight = InputView.inputMaxLadderHeight();

    }
}
