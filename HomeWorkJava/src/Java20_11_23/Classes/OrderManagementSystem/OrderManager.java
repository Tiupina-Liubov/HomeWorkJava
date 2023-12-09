package src.Java20_11_23.Classes.OrderManagementSystem;

import java.util.Arrays;

public class OrderManager extends OrderManagementSystem {
    Product[] listProductsInStock;
    Order[] listNewOrders = new Order[10];

    public Product[] getListProductsInStock() {
        return listProductsInStock;
    }

    public void setListProductsInStock(Product[] listProductsInStock) {
        this.listProductsInStock = listProductsInStock;
    }

    public Order[] getListNewOrders() {
        return listNewOrders;
    }

    public void setListNewOrders(Order[] listNewOrders) {
        this.listNewOrders = listNewOrders;
    }

    public  void newOrders(Order[] listNewOrders, Order... order) {
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < listNewOrders.length; j++) {
                if (listNewOrders[j] == null) {
                    listNewOrders[j] = order[i];
                    OrderManager.newOrderStatus(listNewOrders[i]);
                }

            }

        }
    }

//    public  void newOrderProcessing(Order[] listNewOrders, Product[] listProductsInStock) {
//        for (int i = 0; i < listNewOrders.length; i++) {
//            for (int k = 0; k < listNewOrders[i].getListOfProducts().length; k++) {
//                for (int j = 0; j < listProductsInStock.length; j++) {
//                    if (listNewOrders[i].getListOfProducts()[k].equals(listProductsInStock[j]) && (listProductsInStock[j].getQuantityInStock() != 0)) {
//                        OrderManager.newOrderStatus(listNewOrders[i]);
//                    }
//                }
//            }
//        }
//
//    }

    public static void newOrderStatus(Order order) {
        if (order.orderStatus == true) {
            order.setOrderStatus(false);
        } else {
            order.setOrderStatus(true);
        }
    }

    @Override
    public String toString() {
        return "OrderManager{" +
                "\nlistProductsInStock=" + Arrays.toString(listProductsInStock) +
                ",\n listNewOrders=" + Arrays.toString(listNewOrders) +
                "}\n";
    }
}
