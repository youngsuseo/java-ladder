package ladder.domain;

import java.util.*;

public class Prizes {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    List<String> prizes; // FIXME 일급 컬렉션 & LinkedList ?

    public Prizes(String prizeNames) {
        this(splitPrizes(prizeNames));
    }

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public List<String> getPrizes() {
        return prizes;
    }

    private static List<String> splitPrizes(String prizeNames) {
        if (prizeNames == null || prizeNames.isBlank()) {
            throw new IllegalArgumentException("상품은 빈 값을 입력 할 수 없습니다.");
        }

        String[] splitNames = prizeNames.split(SPILT_COMMA_AND_TRIM);
        return Arrays.asList(splitNames);
    }

    public Players resultPrize(Players players, Ladder ladder) {
        String temp;
        for (int i = ladder.getLines().size() - 1; i >= 0; i--) {
            HorizontalLines horizontalLines = (HorizontalLines) ladder.getLines().get(i);
            for (int j = 0; j < horizontalLines.getConnectingLines().size(); j++) {
                if (horizontalLines.getConnectingLines().get(j)) {
                    temp = prizes.get(j);
                    prizes.set(j, prizes.get(j + 1));
                    prizes.set(j + 1, temp);
                }
            }
        }

        Map<PlayerName, String> playerMap = players.getPlayers();

        int index = 0;
        for (PlayerName playerName : playerMap.keySet()) {
            playerMap.put(playerName, prizes.get(index++));
        }

        return players;
    }
}