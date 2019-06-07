package vendingmachine.coin;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> coins;

    public CoinReturn() {
        this.coins = new ArrayList<Coin>();
    }

    public void addCoin(Coin coin) {
        this.coins.add(coin);
    }

    public int getTotal() {
        int total = 0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        return total;
    }

}
