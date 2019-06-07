import org.junit.Before;
import org.junit.Test;
import vendingmachine.product.Crisps;
import vendingmachine.product.Drink;
import vendingmachine.product.Sweet;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Sweet sweet;
    private Crisps crisps;
    private Drink drink;

    @Before
    public void setUp() {
        sweet = new Sweet("Curly Wurly", "Cadbury");
        crisps = new Crisps("Scampi Fries", "Smiths");
        drink = new Drink("Irn Bru", "Barr");
    }

    @Test
    public void sweetHasNameAndBrand() {
        assertEquals("Curly Wurly", sweet.getName());
        assertEquals("Cadbury", sweet.getBrand());
    }

    @Test
    public void crispsHaveNameAndBrand() {
        assertEquals("Scampi Fries", crisps.getName());
        assertEquals("Smiths", crisps.getBrand());
    }

    @Test
    public void drinkHasNameAndBrand() {
        assertEquals("Irn Bru", drink.getName());
        assertEquals("Barr", drink.getBrand());
    }
}
