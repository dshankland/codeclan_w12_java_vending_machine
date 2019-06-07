import org.junit.Before;
import org.junit.Test;
import vendingmachine.VendingMachine;
import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinReturn;
import vendingmachine.coin.CoinType;
import vendingmachine.drawer.Code;
import vendingmachine.drawer.Drawer;
import vendingmachine.product.Crisps;
import vendingmachine.product.Drink;
import vendingmachine.product.Sweet;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Drawer c1drawer;
    private Drawer d1drawer;
    private Drawer s1drawer;
    private Crisps crisps;
    private Sweet sweet;
    private Drink drink;
    private Coin onecoin;
    private Coin twocoin;
    private Coin fivecoin;
    private Coin tencoin;
    private Coin twentycoin;
    private Coin fiftycoin;
    private Coin poundcoin;

    @Before
    public void setUp() {
        c1drawer = new Drawer(Code.C1, 50);
        d1drawer = new Drawer(Code.D1, 50);
        s1drawer = new Drawer(Code.S1, 50);
        sweet = new Sweet("Curly Wurly", "Cadbury");
        crisps = new Crisps("Scampi Fries", "Smiths");
        drink = new Drink("Irn Bru", "Barr");
        onecoin = new Coin(CoinType.ONE);
        twocoin = new Coin(CoinType.TWO);
        fivecoin = new Coin(CoinType.FIVE);
        tencoin = new Coin(CoinType.TEN);
        twentycoin = new Coin(CoinType.TWENTY);
        fiftycoin = new Coin(CoinType.FIFTY);
        poundcoin = new Coin(CoinType.POUND);
        vendingMachine = new VendingMachine();
    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(onecoin);
        assertEquals(1, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void canAddCoins() {
        vendingMachine.addCoin(onecoin);
        vendingMachine.addCoin(fiftycoin);
        vendingMachine.addCoin(tencoin);
        assertEquals(61, vendingMachine.getEnteredCoinsTotal());
    }

}
