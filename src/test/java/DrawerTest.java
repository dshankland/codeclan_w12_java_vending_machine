import org.junit.Before;
import org.junit.Test;
import vendingmachine.drawer.Code;
import vendingmachine.drawer.Drawer;
import vendingmachine.product.Crisps;
import vendingmachine.product.Drink;
import vendingmachine.product.Product;
import vendingmachine.product.Sweet;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    private Drawer drawer;
    private Crisps crisps;
    private Sweet sweet;
    private Drink drink;

    @Before
    public void setUp() {
        drawer = new Drawer(Code.C1, 50);
        sweet = new Sweet("Curly Wurly", "Cadbury");
        crisps = new Crisps("Scampi Fries", "Smiths");
        drink = new Drink("Irn Bru", "Barr");
    }

    @Test
    public void hasCode() {
        assertEquals(Code.C1, drawer.getCode());
    }

    @Test
    public void drawerHasPrice() {
        assertEquals(50, drawer.getPrice());
    }

    @Test
    public void canAddProduct() {
        drawer.addProduct(crisps);
        assertEquals(1, drawer.countProducts());
    }

    @Test
    public void canReturnProduct() {
        drawer.addProduct(crisps);
        assertEquals(crisps, drawer.returnProduct());
    }

    @Test
    public void canChangeProduct() {
        drawer.addProduct(crisps);
        drawer.returnProduct();
        drawer.addProduct(drink);
        assertEquals(drink, drawer.returnProduct());
    }

}
