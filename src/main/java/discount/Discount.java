package discount;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal calculateDiscount(BigDecimal totalSumOfProducts);

}
