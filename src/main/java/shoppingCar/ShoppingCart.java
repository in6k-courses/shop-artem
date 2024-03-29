package shoppingCar;

import discount.Discount;
import products.Product;
import salls.Sale;

import java.math.BigDecimal;
import java.util.*;

public class ShoppingCart {

    private Discount discountStrategy;
    private Sale saleStrategy;
    private List<Product> shoppingCartWithSale;
    private List<Product> shoppingCart = new ArrayList<Product>();
    private BigDecimal sumOfProducts = new BigDecimal(0.0);
    private BigDecimal sumOfDiscounts = new BigDecimal(0.0);
    private BigDecimal sumOfProductsWithDiscount = new BigDecimal(0.0);

    public ShoppingCart() {
    }

    public ShoppingCart(Discount discountStrategy, Sale saleStrategy) {
        this.discountStrategy = discountStrategy;
        this.saleStrategy = saleStrategy;
    }

    public String generateCheck() {
        applySell();
        applyDiscount();

        String check = "";
        check += "\n";
        for (Product productWithSale : shoppingCartWithSale) {
            check += "Product: " + productWithSale.getProductName() + " Price: " + productWithSale.getPrice().doubleValue() + "\n";
        }
        check += "\n";
        check += "Total price : " + sumOfProducts.doubleValue() + "\n";
        check += "Discount :  " + sumOfDiscounts.doubleValue() + "\n";
        getSumOfProductsWithDiscount();
        check += "Total price with discount : " + sumOfProductsWithDiscount.doubleValue() + "\n";

        return check;
    }

    private void applySell() {
        shoppingCartWithSale = saleStrategy.calculateSale(shoppingCart);
    }

    private void applyDiscount() {
        calculateAllSum();
        sumOfDiscounts = discountStrategy.calculateDiscount(sumOfProducts);
    }

    private void calculateAllSum() {
        Calculate calculateAllSum = new Calculate(shoppingCartWithSale);
        sumOfProducts = calculateAllSum.calculateTotalCost();
    }

    private void getSumOfProductsWithDiscount() {
        sumOfProductsWithDiscount = sumOfProducts.subtract(sumOfDiscounts);
    }


    public void addProductToShoppingCart(Product product) {
        shoppingCart.add(product);
    }


    public void setDiscountStrategy(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }


    public void setSaleStrategy(Sale saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
}
