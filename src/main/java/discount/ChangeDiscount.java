package discount;

import java.math.BigDecimal;

public class ChangeDiscount implements Discount {

    private BigDecimal discountPercent;
    private BigDecimal minSumForDiscount;

    public ChangeDiscount(BigDecimal minSumForDiscount, BigDecimal discountPercent) {
        this.minSumForDiscount = minSumForDiscount;
        this.discountPercent = discountPercent;
    }

    public BigDecimal calculateDiscount(BigDecimal totalSumOfProducts) {
        BigDecimal sumOfDiscount;
        if (totalSumOfProducts.compareTo(minSumForDiscount) > 0) {
            sumOfDiscount = totalSumOfProducts.multiply(discountPercent).divide(new BigDecimal(100));
        } else {
            sumOfDiscount = new BigDecimal(0);
        }
        return sumOfDiscount;
    }

}
