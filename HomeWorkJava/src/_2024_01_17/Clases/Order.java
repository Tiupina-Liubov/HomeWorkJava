package src._2024_01_17.Clases;

import java.util.List;

public class Order {
    private String customerName;
    private List<Item> items;

    private List<Product> products;

    public Order(String customerName, List<Item> items,List<Product> products) {
        this.customerName = customerName;
        this.items = items;
        this.products= products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Product> getProducts() {
        return products;
    }
}
