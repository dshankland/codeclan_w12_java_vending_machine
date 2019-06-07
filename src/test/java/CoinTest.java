import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.gc_interface.CollectedHeapName;
import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinType;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    private Coin onecoin;
    private Coin twocoin;
    private Coin fivecoin;
    private Coin tencoin;
    private Coin twentycoin;
    private Coin fiftycoin;
    private Coin poundcoin;

    @Before

    public void setUp() {
        onecoin = new Coin(CoinType.ONE);
        twocoin = new Coin(CoinType.TWO);
        fivecoin = new Coin(CoinType.FIVE);
        tencoin = new Coin(CoinType.TEN);
        twentycoin = new Coin(CoinType.TWENTY);
        fiftycoin = new Coin(CoinType.FIFTY);
        poundcoin = new Coin(CoinType.POUND);
    }

    @Test
    public void getOneValue() {
        assertEquals(1, onecoin.getValue());
    }
    @Test
    public void getTwoValue() {
        assertEquals(2, twocoin.getValue());
    }
    @Test
    public void getFiveValue() {
        assertEquals(5, fivecoin.getValue());
    }
    @Test
    public void getTenValue() {
        assertEquals(10, tencoin.getValue());
    }
    @Test
    public void getTwentyValue() {
        assertEquals(20, twentycoin.getValue());
    }
    @Test
    public void getFiftyValue() {
        assertEquals(50, fiftycoin.getValue());
    }
    @Test
    public void getPoundValue() {
        assertEquals(100, poundcoin.getValue());
    }
}
