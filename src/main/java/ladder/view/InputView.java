package ladder.view;

import ladder.utils.InputUtils;

public class InputView {
    public static String inputParticipants() {
        return InputUtils.scan("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static String inputWinningPrizes() {
        return InputUtils.scan("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static int inputMaxLadderHeight() {
        String heightOfLadder = InputUtils.scan("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(heightOfLadder);
    }

    public static void printStartLineOfLadderGame() {
        System.out.println("사다리 결과");
    }

    public static String inputWhoWantToSeeResult() {
        return InputUtils.scan("결과를 보고 싶은 사람은?");
    }

    public static String printResultOfChosenPlayer(String result) {
        return InputUtils.scan("실행 결과\n" + result);
    }
}
