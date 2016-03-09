package testDiscount;

import discount.Discount;
import discount.PermanentDiscount;
import org.junit.Test;

import java.math.BigDecimal;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestPermanentDiscount {
    BigDecimal actual;
    BigDecimal expect;

    @Test
    public void testPermanentDiscount() {
        Discount discount = new PermanentDiscount(new BigDecimal(10.00));
        actual = discount.calculateDiscount(new BigDecimal(200.00));
        expect = new BigDecimal(20.00);
        assertThat(actual, is(closeTo(expect,new BigDecimal(0.01))));
    }

}
