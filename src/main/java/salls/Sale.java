package salls;

import products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Sale {

    abstract public List<Product> calculateSale(List<Product> allProducts);

    Map<Product, Product> saleProducts = new HashMap<Product, Product>();
    List<Product> selectedProductsInShoppingCarWithSale = new ArrayList<Product>();

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
