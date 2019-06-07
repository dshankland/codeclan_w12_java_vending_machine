package vendingmachine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinReturn;
import vendingmachine.drawer.Drawer;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> enteredCoins;
    private CoinReturn coinReturn;

    public VendingMachine() {
        drawers = new ArrayList<Drawer>();
        enteredCoins = new ArrayList<Coin>();
        coinReturn = new CoinReturn();
    }


    public void addCoin(Coin coin) {
        this.enteredCoins.add(coin);
    }


    public int getEnteredCoinsTotal() {
        int total = 0;
        for (Coin coin : this.enteredCoins) {
            total += coin.getValue();
        }
        return total;
    }

}
