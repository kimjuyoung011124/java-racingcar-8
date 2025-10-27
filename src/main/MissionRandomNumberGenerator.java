package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionRandomNumberGenerator implements NumberGenerator {
    @Override
    public int next0to9() {
        // 0 ~ 9 범위의 난수
        return Randoms.pickNumberInRange(0, 9);
    }
}
