package salls;

import products.Product;

import java.util.List;

public class WithoutSale extends Sale {

    public List<Product> calculateSale(List<Product> allProducts) {
        return allProducts;
    }
}
