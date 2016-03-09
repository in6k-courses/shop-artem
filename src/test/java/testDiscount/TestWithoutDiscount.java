package testDiscount;

import discount.Discount;
import discount.WithoutDiscount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class TestWithoutDiscount {

    BigDecimal actual;
    BigDecimal expect;

    @Test
    public void testPermanentDiscountMore() {
        Discount withoutDiscount = new WithoutDiscount();
        actual = withoutDiscount.calculateDiscount(new BigDecimal(1000.00));
        expect = new BigDecimal(0.00);
        assertThat(actual, is(closeTo(expect,new BigDecimal(0.01))));
    }
}
