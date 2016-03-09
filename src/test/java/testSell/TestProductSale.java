package testSell;

import products.Product;
import org.junit.Test;
import salls.ProductSale;
import salls.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestProductSale {

    List<Product> actual;
    List<Product> expect;

    @Test
    public void testProductSell() {

        Map<Product,Product> saleProduct = new HashMap<>();
        Product apple = new Product("Apple", new BigDecimal(200));
        Product orange = new Product("Orange", new BigDecimal(1000));
        Product appleSell = new Product("Apple", new BigDecimal(190));

        saleProduct.put(apple,appleSell);
        Sale productSale = new ProductSale(saleProduct);
        productSale.addProduct(apple, appleSell);

        List<Product> products = new ArrayList<Product>();
        products.add(apple);
        products.add(orange);

        expect = new ArrayList<Product>();
        expect.add(appleSell);
        expect.add(orange);

        actual = productSale.calculateSale(products);
        assertThat(actual, is(expect));
    }


}
