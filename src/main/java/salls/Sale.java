package salls;

import products.Product;

import java.util.*;

public abstract class Sale {

    abstract public List<Product> calculateSale(List<Product> allProducts);

    Map<Product, Product> saleProducts = new HashMap<Product, Product>();
    List<Product> selectedProductsInShoppingCarWithSale = new ArrayList<Product>();

    public void addProduct(Product sellProduct, Product giftProduct) {
        saleProducts.put(sellProduct, giftProduct);
    }

    public void removeProductFromSale(Product sellProduct) {
        saleProducts.remove(sellProduct);
    }

}
