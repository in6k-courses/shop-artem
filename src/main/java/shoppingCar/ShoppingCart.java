package shoppingCar;

import discount.Discount;
import products.Product;
import salls.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private Discount discountStrategy;
    private Sale saleStrategy;
    private List<Product> shoppingCar = new ArrayList<Product>();
    private List<Product> shoppingCarWithSale = new ArrayList<Product>();
    private BigDecimal sumOfProducts = new BigDecimal(0.0);
    private BigDecimal sumOfDiscount = new BigDecimal(0.0);
    private BigDecimal sumOfProductsWithDiscount = new BigDecimal(0.0);

    public ShoppingCart() {
    }

    public ShoppingCart(Discount discountStrategy, Sale saleStrategy) {
        this.discountStrategy = discountStrategy;
        this.saleStrategy = saleStrategy;
    }

    public String generateCheck() {
        String check = "";
        applySell();
        applyDiscount();

        check += "\n";
        for (int i = 0; i < shoppingCarWithSale.size(); i++) {
            Product productWithSale = shoppingCarWithSale.get(i);
            check += "Product: " + productWithSale.getProductName() + " Price: " + productWithSale.getPrice().doubleValue() + "\n";
        }
        check += "\n";
        check += "Total price : " + sumOfProducts.doubleValue() + "\n";
        check += "Discount :  " + sumOfDiscount.doubleValue() + "\n";
        getSumOfProductsWithDiscount();
        check += "Total price with discount : " + sumOfProductsWithDiscount.doubleValue() + "\n";

        return check;
    }


    public void printCheck() {
        String check = generateCheck();
        System.out.println(check);

    }
    private void applySell() {
        shoppingCarWithSale = saleStrategy.calculateSale(shoppingCar);
    }

    private void applyDiscount() {
        calculateAllSum();
        sumOfDiscount = discountStrategy.calculateDiscount(sumOfProducts);

    }

    private void calculateAllSum() {
        Calculate calculateAllSum = new Calculate(shoppingCarWithSale);
        sumOfProducts = calculateAllSum.calculateTotalCost();
    }

    private void getSumOfProductsWithDiscount(){
        sumOfProductsWithDiscount = sumOfProducts.subtract(sumOfDiscount);
    }

    public BigDecimal getSumOfProducts() {
        return sumOfProducts;
    }

    public void addProductToShoppingCar(Product product) {
        shoppingCar.add(product);
    }

    public Discount getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Sale getSaleStrategy() {
        return saleStrategy;
    }

    public void setSaleStrategy(Sale saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

}
