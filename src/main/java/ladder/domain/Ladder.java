package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static List<List<Boolean>> create(int countOfPerson, int numberOfMoves) {
        List<List<Boolean>> ladders = new ArrayList<>();

        for (int index = 0; index < numberOfMoves; index++) {
            List<Boolean> points = new ArrayList<>();
            for (int i = 0; i < countOfPerson - 1; i++) {
                points.add(false);
            }
            ladders.add(points);
        }

        return ladders;
    }
}
