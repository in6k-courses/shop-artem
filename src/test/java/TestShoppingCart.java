import discount.*;

import org.junit.Before;
import org.junit.Test;

import products.Product;
import salls.*;
import shoppingCar.ShoppingCart;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class TestShoppingCart {

    ShoppingCart shoppingCart;
    Sale saleStrategy;
    Discount discountStrategy;

    @Before
    public void init() {
        Product apple = new Product("Apple", new BigDecimal(200));
        Product orange = new Product("Orange", new BigDecimal(1000));

        shoppingCart = new ShoppingCart();
        shoppingCart.addProductToShoppingCart(apple);
        shoppingCart.addProductToShoppingCart(orange);
    }

    @Test
    public void testWithoutSaleAndDiscount() {
        discountStrategy = new WithoutDiscount();
        saleStrategy = new WithoutSale();

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1200.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1200.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testWithoutSaleAndWithPermanentDiscount() {
        discountStrategy = new PermanentDiscount(new BigDecimal(10));
        saleStrategy = new WithoutSale();

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1200.0\n"
                + "Discount :  120.0\n"
                + "Total price with discount : 1080.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testWithoutSaleAndWithChangeDiscountMoreMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1000), new BigDecimal(10));
        saleStrategy = new WithoutSale();

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1200.0\n"
                + "Discount :  120.0\n"
                + "Total price with discount : 1080.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testWithoutSaleAndWithChangeDiscountLessMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1400), new BigDecimal(10));
        saleStrategy = new WithoutSale();

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1200.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1200.0\n";

        assertThat(actualCheck, is(expectCheck));
    }


    @Test
    public void testGiftSaleAndWithoutDiscount() {
        discountStrategy = new WithoutDiscount();
        saleStrategy = new GiftSale(getGifts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Tea Price: 1.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1201.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1201.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testGiftSaleAndPermanentDiscount() {
        discountStrategy = new PermanentDiscount(new BigDecimal(10));
        saleStrategy = new GiftSale(getGifts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Tea Price: 1.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1201.0\n"
                + "Discount :  120.1\n"
                + "Total price with discount : 1080.9\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testGiftSaleAndChangeDiscountMoreMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1000), new BigDecimal(10));
        saleStrategy = new GiftSale(getGifts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Tea Price: 1.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1201.0\n"
                + "Discount :  120.1\n"
                + "Total price with discount : 1080.9\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testGiftSaleAndChangeDiscountLessMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1400), new BigDecimal(10));
        saleStrategy = new GiftSale(getGifts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 200.0\n"
                + "Product: Tea Price: 1.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1201.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1201.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    public Map<Product, Product> getGifts() {
        Map<Product, Product> giftProduct = new HashMap<>();
        Product apple = new Product("Apple", new BigDecimal(200));
        Product tea = new Product("Tea", new BigDecimal(1.00));
        giftProduct.put(apple, tea);
        return giftProduct;
    }

    @Test
    public void testProductSaleAndWithOutDiscount() {
        discountStrategy = new WithoutDiscount();
        saleStrategy = new ProductSale(getSaleProducts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 190.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1190.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1190.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testProductSaleAndWithPermanentDiscount() {
        discountStrategy = new PermanentDiscount(new BigDecimal(10));
        saleStrategy = new ProductSale(getSaleProducts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 190.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1190.0\n"
                + "Discount :  119.0\n"
                + "Total price with discount : 1071.0\n";

        assertThat(actualCheck, is(expectCheck));
    }


    @Test
    public void testProductSaleAndWithChangeDiscountMoreMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1000), new BigDecimal(10));
        saleStrategy = new ProductSale(getSaleProducts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 190.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1190.0\n"
                + "Discount :  119.0\n"
                + "Total price with discount : 1071.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    @Test
    public void testProductSaleAndWithChangeDiscountLessMinimum() {
        discountStrategy = new ChangeDiscount(new BigDecimal(1400), new BigDecimal(10));
        saleStrategy = new ProductSale(getSaleProducts());

        shoppingCart.setDiscountStrategy(discountStrategy);
        shoppingCart.setSaleStrategy(saleStrategy);

        String actualCheck = shoppingCart.generateCheck();
        String expectCheck = "\n" + "Product: Apple Price: 190.0\n"
                + "Product: Orange Price: 1000.0\n"
                + "\nTotal price : 1190.0\n"
                + "Discount :  0.0\n"
                + "Total price with discount : 1190.0\n";

        assertThat(actualCheck, is(expectCheck));
    }

    public Map<Product, Product> getSaleProducts() {
        Map<Product, Product> giftProduct = new HashMap<>();
        Product apple = new Product("Apple", new BigDecimal(200));
        Product appleWithSale = new Product("Apple", new BigDecimal(190));
        giftProduct.put(apple, appleWithSale);
        return giftProduct;
    }

    @Test
    public void testAddProductToShoppingCart() {
        Product apple = new Product("Apple", new BigDecimal(200));
        List<Product> actualShoppingCart = shoppingCart.getShoppingCart();

        assertThat(apple, isIn(actualShoppingCart));
    }

}
