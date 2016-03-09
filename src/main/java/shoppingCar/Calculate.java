package shoppingCar;

import products.Product;

import java.math.BigDecimal;
import java.util.List;

public class Calculate {
    private List<Product> shoppingCart;

    public Calculate(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public BigDecimal calculateTotalCost(){

        BigDecimal totalCost = new BigDecimal(0.0);

        for (Product product : shoppingCart){
           totalCost = totalCost.add(product.getPrice());
        }
        return totalCost;
    }
}
