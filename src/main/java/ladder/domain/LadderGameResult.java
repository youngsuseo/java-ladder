package ladder.domain;

import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.engine.LineCreator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderGameResult implements LadderResult {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    private final List<String> results;

    public LadderGameResult(String prizeNames) {
        this(splitPrizes(prizeNames));
    }

    public LadderGameResult(List<String> results) {
        this.results = results;
    }

    private static List<String> splitPrizes(String prizeNames) {
        if (prizeNames == null || prizeNames.isBlank()) {
            throw new IllegalArgumentException("상품은 빈 값을 입력 할 수 없습니다.");
        }

        String[] splitNames = prizeNames.split(SPILT_COMMA_AND_TRIM);
        return Arrays.asList(splitNames);
    }

    @Override
    public Players result(Players players, LadderCreator ladderCreator) {
        List<? extends LineCreator> lines = ladderCreator.getLines();
        for (int maxLadderSize = lines.size() - 1; maxLadderSize >= 0; maxLadderSize--) {
            LadderLine ladderLine = (LadderLine) lines.get(maxLadderSize);
            changePositionByLine(ladderLine);
        }

        int index = 0;
        Map<PlayerName, String> playerMap = players.getPlayers();
        for (PlayerName playerName : playerMap.keySet()) {
            playerMap.put(playerName, results.get(index++));
        }

        return players;
    }

    private void changePositionByLine(LadderLine ladderLine) {
        List<Boolean> connectingLines = ladderLine.getConnectingLines();
        for (int lineIndex = 0; lineIndex < connectingLines.size(); lineIndex++) {
            changePosition(connectingLines, lineIndex);
        }
    }

    private void changePosition(List<Boolean> connectingLines, int lineIndex) {
        String temp;
        if (connectingLines.get(lineIndex)) {
            temp = results.get(lineIndex);
            results.set(lineIndex, results.get(lineIndex + 1));
            results.set(lineIndex + 1, temp);
        }
    }
}
