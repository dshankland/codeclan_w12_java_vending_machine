package vendingmachine.drawer;

import vendingmachine.product.Product;

import java.util.ArrayList;

public class Drawer {

    private Code code;
    private int price;
    private ArrayList<Product> products;

    public Drawer(Code code, int price) {
        this.code = code;
        this.price = price;
        this.products = new ArrayList<Product>();
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Product returnProduct() {
        if (this.products.size() > 0) {
            return this.products.remove(0);
        }
        return null;
    }

    public int countProducts() {
        return this.products.size();
    }
}
