package vendingmachine.coin;

import java.util.Arrays;
import java.util.Optional;

public enum CoinType {

    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    POUND(100);

    private final int value;

    CoinType(int value) {
        this.value = value;
    }

    public int getValueFromEnum() {
        return this.value;
    }

}

