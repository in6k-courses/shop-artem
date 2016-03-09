package salls;

import products.Product;

import java.util.*;

public class ProductSale extends Sale {

    public ProductSale(Map<Product, Product> productSale) {
            this.saleProducts = productSale;
    }

    @Override
    public List<Product> calculateSale(List<Product> allProducts) {

        for (Product productInShopingCar : allProducts) {

            if (saleProducts.containsKey(productInShopingCar)) {
                Product saleProduct = saleProducts.get(productInShopingCar);
                selectedProductsInShoppingCarWithSale.add(saleProduct);
            } else {
                selectedProductsInShoppingCarWithSale.add(productInShopingCar);
            }
        }
        return selectedProductsInShoppingCarWithSale;
    }

}
