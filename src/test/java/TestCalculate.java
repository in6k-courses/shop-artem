import org.junit.Test;

import products.Product;
import shoppingCar.Calculate;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestCalculate {

    @Test
    public void testCalculateTotalCost() {
        List<Product> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Product("Tea", new BigDecimal(200)));
        shoppingCart.add(new Product("Milk", new BigDecimal(120)));

        Calculate testCalc = new Calculate(shoppingCart);

        BigDecimal actual = testCalc.calculateTotalCost();
        BigDecimal expect = new BigDecimal(320);
        assertThat(actual, is(expect));
    }

}
