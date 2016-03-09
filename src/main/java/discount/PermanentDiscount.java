package discount;

import java.math.BigDecimal;

public class PermanentDiscount implements Discount {

    private BigDecimal discountPercent;

    public PermanentDiscount(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal calculateDiscount(BigDecimal totalSumOfProducts) {

        return totalSumOfProducts.multiply(discountPercent).divide(new BigDecimal(100.00));
    }

    public BigDecimal getDiscount() {
        return discountPercent;
    }

}
