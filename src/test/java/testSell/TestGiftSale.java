package testSell;

import products.Product;
import org.junit.Test;
import salls.GiftSale;
import salls.Sale;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestGiftSale {
    List<Product> actual;
    List<Product> expect;

    @Test
    public void testPermanentSell() {
        Map<Product,Product> sale = new HashMap<>();
        Product apple = new Product("Apple", new BigDecimal(200));
        Product orange = new Product("Orange", new BigDecimal(1000));
        Product tea = new Product("Tea", new BigDecimal(1.00));

        sale.put(apple,tea);
        Sale giftSale = new GiftSale(sale);

        List<Product> product = new ArrayList<Product>();
        product.add(apple);
        product.add(orange);

        expect = new ArrayList<Product>();
        expect.add(apple);
        expect.add(tea);
        expect.add(orange);


        actual = giftSale.calculateSale(product);

        assertThat(actual, is(expect));

    }
}
