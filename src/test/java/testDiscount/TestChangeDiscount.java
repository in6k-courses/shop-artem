package testDiscount;

import discount.ChangeDiscount;
import discount.Discount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestChangeDiscount {

    BigDecimal actual;
    BigDecimal expect;
    Discount changeDiscount;

    @Before
    public void init(){
        changeDiscount = new ChangeDiscount(new BigDecimal(2000), new BigDecimal(2));
    }

    @Test
    public void testWithSumMoreThanMinSumDiscount() {
        actual = changeDiscount.calculateDiscount(new BigDecimal(3000));
        expect = new BigDecimal(60);
        assertThat(actual, is(closeTo(expect,new BigDecimal(0.01))));
    }

    @Test
    public void testWithSumLessThanMinSumDiscount() {
        actual = changeDiscount.calculateDiscount(new BigDecimal(1000));
        expect = new BigDecimal(0);
        assertThat(actual, is(closeTo(expect,new BigDecimal(0.01))));
    }

}
