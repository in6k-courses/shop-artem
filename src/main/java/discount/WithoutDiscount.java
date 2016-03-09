package discount;

import java.math.BigDecimal;

public class WithoutDiscount implements Discount {
    public BigDecimal calculateDiscount(BigDecimal totalSumOfProducts) {
        return new BigDecimal(0);
    }
}
