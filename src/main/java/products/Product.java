package products;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private BigDecimal price;

    public Product(String items, BigDecimal price) {
        this.productName = items;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productName.equals(product.productName)) return false;
        return price.equals(product.price);

    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
