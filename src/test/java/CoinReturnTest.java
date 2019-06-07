import org.junit.Before;
import org.junit.Test;
import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinReturn;
import vendingmachine.coin.CoinType;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    private CoinReturn coinReturn;
    private Coin onecoin;
    private Coin twocoin;
    private Coin fivecoin;
    private Coin tencoin;
    private Coin twentycoin;
    private Coin fiftycoin;
    private Coin poundcoin;

    @Before
    public void setUp() {
        coinReturn = new CoinReturn();
        onecoin = new Coin(CoinType.ONE);
        twocoin = new Coin(CoinType.TWO);
        fivecoin = new Coin(CoinType.FIVE);
        tencoin = new Coin(CoinType.TEN);
        twentycoin = new Coin(CoinType.TWENTY);
        fiftycoin = new Coin(CoinType.FIFTY);
        poundcoin = new Coin(CoinType.POUND);
    }

    @Test
    public void canAddCoin() {
        coinReturn.addCoin(onecoin);
        assertEquals(1, coinReturn.getTotal());
    }

    @Test
    public void canAddAFewCoinsAndGetTotal() {
        coinReturn.addCoin(onecoin);
        coinReturn.addCoin(twocoin);
        coinReturn.addCoin(fivecoin);
        coinReturn.addCoin(tencoin);
        coinReturn.addCoin(twentycoin);
        coinReturn.addCoin(fiftycoin);
        coinReturn.addCoin(poundcoin);
        assertEquals(188, coinReturn.getTotal());
    }
}
