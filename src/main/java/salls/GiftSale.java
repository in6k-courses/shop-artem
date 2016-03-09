package salls;

import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GiftSale extends Sale {

    public GiftSale(Map<Product, Product> gifts) {
        this.saleProducts =gifts;
    }

    @Override
    public List<Product> calculateSale(List<Product> allProducts) {
        List<Product> selectedProductsInShoppingCarWithSale = new ArrayList<Product>();
        for (Product productInShopingCar : allProducts) {

            if (saleProducts.containsKey(productInShopingCar)) {
                Product sell = saleProducts.get(productInShopingCar);
                selectedProductsInShoppingCarWithSale.add(productInShopingCar);
                selectedProductsInShoppingCarWithSale.add(sell);
            } else {
                selectedProductsInShoppingCarWithSale.add(productInShopingCar);
            }
        }
        return selectedProductsInShoppingCarWithSale;
    }

    public void addProduct(Product sellProduct, Product giftProduct) {
        saleProducts.put(sellProduct, giftProduct);
    }

    public Map<Product, Product> getSellProducts() {
        return saleProducts;
    }

    public void removeProduct(Product sellProduct) {
        saleProducts.remove(sellProduct);
    }


}
