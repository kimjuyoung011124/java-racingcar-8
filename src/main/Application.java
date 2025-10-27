package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 입력 안내 및 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundsInput = Console.readLine();

        // 파싱 & 검증
        List<String> names = InputParser.parseNames(namesInput);
        Validator.validateNames(names);

        int rounds = InputParser.parseRounds(roundsInput);
        Validator.validateRounds(rounds);

        // 도메인 조립
        List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
        RacingGame game = new RacingGame(cars, new MissionRandomNumberGenerator());

        // 출력
        OutputView view = new OutputView();
        view.printExecutionHeader();

        for (int i = 0; i < rounds; i++) {
            game.moveOnce();
            view.printRound(game.getCars()); // 라운드 결과 + 빈 줄
        }

        List<Car> winners = game.findWinners();
        view.printWinners(winners);
    }
}

