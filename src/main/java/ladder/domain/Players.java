package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Players {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    public static List<String> create(String names) {
        String[] splitNames = names.split(SPILT_COMMA_AND_TRIM);
        return Arrays.asList(splitNames);
    }






//
//    private Map<String, Integer> players;
//
//    public Players(List<String> names, int numberOfMoves) {
//        Map<String, Integer> playerMap = new LinkedHashMap<>() {
//            {
//
//            }
//        };
//
//
//        this.names = names;
//        this.numberOfMoves = numberOfMoves;
//    }
//
//    public Players(Map<String, Integer> players) {
//        this.players = players;
//    }
}
