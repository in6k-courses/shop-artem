package testSell;

import products.Product;
import org.junit.Test;
import salls.Sale;
import salls.WithoutSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestWithoutSale {

    List<Product> actual;
    List<Product> expect;

    @Test
    public void testPermanentSell() {
        Sale giftSale = new WithoutSale();

        Product apple = new Product("Apple", new BigDecimal(200));
        Product orange = new Product("Orange", new BigDecimal(1000));

        List<Product> products = new ArrayList<Product>();
        products.add(apple);
        products.add(orange);

        expect = new ArrayList<Product>();
        expect.add(apple);
        expect.add(orange);

        actual = giftSale.calculateSale(products);
        assertThat(actual, is(expect));
    }
}
