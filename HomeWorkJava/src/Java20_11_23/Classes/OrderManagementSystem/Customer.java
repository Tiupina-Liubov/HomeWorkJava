package src.Java20_11_23.Classes.OrderManagementSystem;

import java.util.Arrays;

public class Customer {
    String nameCustomer;
    String emailCustomer;
    Product[] listOfProductsOrders = new Product[5];
    Order[] orders = new Order[5];
    Order[] historyOrdersCustomer = new Order[5];


    public Customer(String nameCustomer, String emailCustomer) {
        this.nameCustomer = nameCustomer;
        this.emailCustomer = emailCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public Product[] getListOfProductsOrders() {
        return listOfProductsOrders;
    }

    public Order[] getHistoryOrdersCustomer() {
        return historyOrdersCustomer;
    }


    public void setListOfProductsOrders(Product[] listOfProductsOrders) {
        this.listOfProductsOrders = listOfProductsOrders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer" +
                "\nNameCustomer='" + nameCustomer + "\nEmailCustomer=" + emailCustomer + "\nListOfProductsOrders=" + Arrays.toString(listOfProductsOrders);
    }

    public Order addOrder(Product ... product) {
        Order order = new Order();
        for (int i = 0; i < product.length; i++) {
            Order.addItemOrderProduct(product[i], listOfProductsOrders);
        }
        System.out.println(Arrays.toString(listOfProductsOrders));
        float totalAmount = Order.totalAmountOrder(listOfProductsOrders);
        order.setOrderStatus(true);
        order.setListOfProducts(listOfProductsOrders);
        order.setTotalAmount(totalAmount);
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders[i] = order;
            }
        }
        return order;
    }

    public void removeOrder(Order order) {
        for (int i = 0; i < order.listOfProducts.length; i++) {
            order.listOfProducts[i] = null;
        }
            order.setTotalAmount(0.0f);
            order.setOrderStatus(false);

    }
}