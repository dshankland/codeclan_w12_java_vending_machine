package vendingmachine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinReturn;
import vendingmachine.drawer.Code;
import vendingmachine.drawer.Drawer;
import vendingmachine.product.Crisps;
import vendingmachine.product.Product;

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

    public void addDrawer(Drawer drawer) {
        this.drawers.add(drawer);
    }

    public void addCoin(Coin coin) {
        if (this.isCoinValid(coin)) {
            this.enteredCoins.add(coin);
        }
        else {
            this.coinReturn.addCoin(coin);
        }
    }

    public int getEnteredCoinsTotal() {
        int total = 0;
        for (Coin coin : this.enteredCoins) {
            total += coin.getValue();
        }
        return total;
    }

    public boolean isCoinValid(Coin coin) {
        if (coin.getValue() >= 5) {
            return true;
        }
        return false;
    }

    public Product vend(Code code) {
        for (Drawer drawer : drawers) {
            if (drawer.getCode() == code) {
                return drawer.returnProduct();
            }
        }
        return null;
    }

    public int getVendPrice(Code code) {
        for (Drawer drawer : drawers) {
            if (drawer.getCode() == code) {
                return drawer.getPrice();
            }
        }
        return 999999999;
    }

    public boolean sufficientFunds(int vendPrice) {
        return this.getEnteredCoinsTotal() >= vendPrice;
    }

    public Product buy(Code code) {
        int priceToBuy = this.getVendPrice(code);
        if (this.sufficientFunds(priceToBuy)) {
            this.enteredCoins.clear();
            return this.vend(code);
        }
        return null;
    }
}
