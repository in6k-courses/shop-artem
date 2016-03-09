package salls;

import products.Product;

import java.util.List;
import java.util.Map;

public class ProductSale extends Sale {

    public ProductSale(Map<Product, Product> productSale) {
            this.saleProducts = productSale;
    }

    @Override
    public List<Product> calculateSale(List<Product> allProducts) {

        for (Product productInShopingCar : allProducts) {

            if (saleProducts.containsKey(productInShopingCar)) {
                Product sell = saleProducts.get(productInShopingCar);
                selectedProductsInShoppingCarWithSale.add(sell);
            } else {
                selectedProductsInShoppingCarWithSale.add(productInShopingCar);
            }
        }
        return selectedProductsInShoppingCarWithSale;
    }

}
