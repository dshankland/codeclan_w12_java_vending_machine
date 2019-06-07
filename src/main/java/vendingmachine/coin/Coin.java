package vendingmachine.coin;

public class Coin {
    private CoinType coin;

    public Coin(CoinType coin) {
        this.coin = coin;
    }

    public int getValue() {
        return coin.getValueFromEnum();
    }
}
