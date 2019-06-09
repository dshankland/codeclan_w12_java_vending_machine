package vendingmachine.coin;

public class Coin {
    private CoinType coin;

    public Coin(CoinType coin) {
        this.coin = coin;
    }

    public int getValue() {
        return coin.getValueFromEnum();
    }

    public static boolean isItACoin(int value) {
        for (CoinType coin : CoinType.values()) {
            if (value == coin.getValueFromEnum()) {
                return true;
            }
        }
        return false;
    }

}
