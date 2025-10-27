package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 사용자 안내 문구
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesRaw = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundsRaw = Console.readLine();

        // 입력 문자열 파싱
        List<String> names = InputParser.parseNames(namesRaw);
        int rounds = InputParser.parseRounds(roundsRaw);

        // 파싱 결과 확인용 출력 (임시)
        System.out.println("입력된 자동차 이름: " + names);
        System.out.println("입력된 시도 횟수: " + rounds);

    }
}
