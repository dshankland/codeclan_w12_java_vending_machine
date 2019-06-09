package vendingmachine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinReturn;
import vendingmachine.drawer.Code;
import vendingmachine.drawer.Drawer;
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
        // Do'n like this return, but couldn't think of anything better!
        return 999999999;
    }

    public boolean sufficientFunds(int vendPrice) {
        return this.getEnteredCoinsTotal() >= vendPrice;
    }

    public Product buy(Code code) {
        int change;
        int priceToBuy = this.getVendPrice(code);
        if (this.sufficientFunds(priceToBuy)) {
//            this.enteredCoins.clear();
            this.calculateAndDeliverChange(priceToBuy);
            return this.vend(code);
        }
        return null;
    }

    public void returnCoins() {
        for (Coin coin : this.enteredCoins) {
            this.coinReturn.addCoin(coin);
        }
        this.enteredCoins.clear();
    }

    public int getCoinReturnTotal() {
        return coinReturn.getTotal();
    }

    public boolean doesEnteredCoinsContainCoin(int coinValue) {
        for (Coin coin : this.enteredCoins) {
            if (coin.getValue() == coinValue) {
                return true;
            }
        }
        return false;
    }

    public void calculateAndDeliverChange(int vendPrice) {
        // we assume the vendPrice has already been compared to the enteredCoins value in the buy method
        int changeTotal = this.getEnteredCoinsTotal() - vendPrice;
        int runningTotal = 0;
        if (changeTotal == 0) {
            returnCoins();
        }
        else {
            ArrayList<Integer> indexOfCoins = new ArrayList<Integer>();
            this.bubbleSortEnteredCoins();
            // loop round the entered coins
            int index = 0;
            for (Coin coin : this.enteredCoins) {
                // if the current coin value is less than the vend price add it to an ArrayList of coins to be removed
                // from the enteredCoins ArrayList and remove the coin value from the vend price
                if (coin.getValue() < vendPrice) {
                    indexOfCoins.add(index);
                    vendPrice -= coin.getValue();
                }
                // the coin value is greater than or equal to the vend price
                else {
                    // if it's equal to the value, then we are laughing, we have the exact amount and the change
                  if (coin.getValue() == vendPrice) {
                      indexOfCoins.add(index);
                      vendPrice -= coin.getValue();
                      break;
                  }
                  // this is where my logic falls down. This should do something clever depending on what is left
                  // in the enteredCoins ArrayList
                  else {
                      // if we're at the last of the enteredCoins ArrayList we need to add this coin
                      // meaning no change.
                      if (index == this.enteredCoins.size() - 1) {
                          indexOfCoins.add(index);
                          vendPrice -= coin.getValue();
                          break;
                      }
                      // this is where we should try and calculate what's left in the enteredCoins from this index on
                      // and figure out what to do based on that value
                      else {

                      }
                  }
                }
                index++;
            }
            // loop around the ArrayList of indexes of coins to remove from enteredCoins. We go backwards
            // so we preserve the indexes of the ArrayList. Hacky McHackhack.
            for (int i = indexOfCoins.size() - 1; i >= 0; i--) {
                this.enteredCoins.remove(indexOfCoins.get(i).intValue());
            }
            returnCoins();
        }
    }

    public void bubbleSortEnteredCoins() {
        for (int outerIndex = 0; outerIndex < this.enteredCoins.size(); outerIndex++) {
            for (int innerIndex = 0; innerIndex < this.enteredCoins.size() - outerIndex - 1; innerIndex++) {
                if (this.enteredCoins.get(innerIndex).getValue() < this.enteredCoins.get(innerIndex + 1).getValue() ) {
                    Coin temp = this.enteredCoins.get(innerIndex);
                    this.enteredCoins.set(innerIndex, this.enteredCoins.get(innerIndex + 1));
                    this.enteredCoins.set(innerIndex + 1, temp);
                }
            }
        }
    }


}
