import org.junit.Before;
import org.junit.Test;
import vendingmachine.VendingMachine;
import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinType;
import vendingmachine.drawer.Code;
import vendingmachine.drawer.Drawer;
import vendingmachine.product.Crisps;
import vendingmachine.product.Drink;
import vendingmachine.product.Product;
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
    private Product vendedProduct;

    @Before
    public void setUp() {
        c1drawer = new Drawer(Code.C1, 50);
        d1drawer = new Drawer(Code.D1, 100);
        s1drawer = new Drawer(Code.S1, 65);
        sweet = new Sweet("Curly Wurly", "Cadbury");
        crisps = new Crisps("Scampi Fries", "Smiths");
        drink = new Drink("Irn Bru", "Barr");
        c1drawer.addProduct(crisps);
        d1drawer.addProduct(drink);
        s1drawer.addProduct(sweet);
        onecoin = new Coin(CoinType.ONE);
        twocoin = new Coin(CoinType.TWO);
        fivecoin = new Coin(CoinType.FIVE);
        tencoin = new Coin(CoinType.TEN);
        twentycoin = new Coin(CoinType.TWENTY);
        fiftycoin = new Coin(CoinType.FIFTY);
        poundcoin = new Coin(CoinType.POUND);
        vendingMachine = new VendingMachine();
        vendingMachine.addDrawer(c1drawer);
        vendingMachine.addDrawer(d1drawer);
        vendingMachine.addDrawer(s1drawer);
    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(twentycoin);
        assertEquals(20, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void canAddCoins() {
        vendingMachine.addCoin(fiftycoin);
        vendingMachine.addCoin(tencoin);
        assertEquals(60, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void isCoinValid() {
        assertEquals(false, vendingMachine.isCoinValid(onecoin));
        assertEquals(false, vendingMachine.isCoinValid(twocoin));
        assertEquals(true, vendingMachine.isCoinValid(fivecoin));
    }

    @Test
    public void ifCoinInvalidAddToReturn() {
        vendingMachine.addCoin(onecoin);
        vendingMachine.addCoin(onecoin);
        vendingMachine.addCoin(twocoin);
        vendingMachine.addCoin(twocoin);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void ifCoinValidAddToEnteredCoins() {
        vendingMachine.addCoin(fivecoin);
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(fiftycoin);
        vendingMachine.addCoin(poundcoin);
        assertEquals(185, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void canVend() {
        assertEquals(crisps, vendingMachine.vend(Code.C1));
    }

    @Test
    public void canBuyProduct() {
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendedProduct = vendingMachine.buy(Code.C1);
        assertEquals(crisps, vendedProduct);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void cannotBuyProduct() {
        vendingMachine.addCoin(tencoin);
        vendedProduct = vendingMachine.buy(Code.C1);
        assertEquals(null, vendedProduct);
        assertEquals(10, vendingMachine.getEnteredCoinsTotal());
    }

    @Test
    public void canReturnCoins() {
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.returnCoins();
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
        assertEquals(50, vendingMachine.getCoinReturnTotal());
    }

    @Test
    public void enteredCoinsContainsSpecificCoin() {
        vendingMachine.addCoin(tencoin);
        assertEquals(true, vendingMachine.doesEnteredCoinsContainCoin(10));
    }

    @Test
    public void enteredCoinsDoesNotContainSpecificCoin() {
        vendingMachine.addCoin(tencoin);
        assertEquals(false, vendingMachine.doesEnteredCoinsContainCoin(5));
    }

    @Test
    public void willReturnChange() {
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(fiftycoin);
        vendingMachine.addCoin(twentycoin);
        vendedProduct = vendingMachine.buy(Code.C1);
        assertEquals(crisps, vendedProduct);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
        assertEquals(50, vendingMachine.getCoinReturnTotal());
    }

    @Test
    public void willFailToReturnExactChange() {
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendedProduct = vendingMachine.buy(Code.C1);
        assertEquals(crisps, vendedProduct);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
        assertEquals(0, vendingMachine.getCoinReturnTotal());
    }

    @Test
    public void testBuyMethodWithChangeThatWillConfuseIt() {
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendedProduct = vendingMachine.buy(Code.C1);
        assertEquals(crisps, vendedProduct);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
        assertEquals(0, vendingMachine.getCoinReturnTotal());
    }

    @Test
    public void testBuyMethodOnCurlyWurlyWithChangeThatWillConfuseIt() {
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(twentycoin);
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(tencoin);
        vendingMachine.addCoin(fivecoin);
        vendingMachine.addCoin(fivecoin);
        vendedProduct = vendingMachine.buy(Code.S1);
        assertEquals(sweet, vendedProduct);
        assertEquals(0, vendingMachine.getEnteredCoinsTotal());
        assertEquals(35, vendingMachine.getCoinReturnTotal());
    }


}

