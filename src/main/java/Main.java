/**
 * Created by employee on 09.03.16.
 */
import discount.ChangeDiscount;
import discount.Discount;
import products.Product;
import salls.GiftSale;
import salls.Sale;
import shoppingCar.ShoppingCart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by employee on 03.03.16.
 */
public class Main {

    public static void main(String[] args) {

        Discount changeDiscount = new ChangeDiscount(new BigDecimal(1500),new BigDecimal(3));

        Map<Product,Product> giftsForShopping = new HashMap<>();
        giftsForShopping.put(new Product("Apple",new BigDecimal(200)), new Product("Flash 64Gb", new BigDecimal(1.00)));
        Sale giftSell = new GiftSale(giftsForShopping);

        Product apple = new Product("Apple", new BigDecimal(200));
        Product orange = new Product("Orange", new BigDecimal(1000));
        Product kiwi = new Product("Kiwi", new BigDecimal(700));
        Product tv = new Product("TV", new BigDecimal(10000));
        Product mobile = new Product("Mobile", new BigDecimal(2000));
        Product microwave = new Product("Microwave", new BigDecimal(1500));
        Product teapot = new Product("Teapot", new BigDecimal(291));

        ShoppingCart shoppingCar = new ShoppingCart(changeDiscount,giftSell);
        shoppingCar.addProductToShoppingCar(apple);
        shoppingCar.addProductToShoppingCar(orange);
        shoppingCar.addProductToShoppingCar(kiwi);
        shoppingCar.addProductToShoppingCar(tv);
        shoppingCar.addProductToShoppingCar(mobile);
        shoppingCar.addProductToShoppingCar(microwave);
        shoppingCar.addProductToShoppingCar(teapot);

        System.out.println(shoppingCar.generateCheck());





    }
}

