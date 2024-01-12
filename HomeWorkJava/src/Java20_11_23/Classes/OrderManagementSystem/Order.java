package src.Java20_11_23.Classes.OrderManagementSystem;

import java.util.Arrays;

public class Order extends OrderManagementSystem {
    Product[] listOfProducts = new Product[5];
    boolean orderStatus;
    float totalAmount;

    public Product[] getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(Product[] listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static void addItemOrderProduct(Product product, Product[] listOfProducts) {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] == null) {
                listOfProducts[i] = product;
                break;
            }
        }
    }

    public static void removeItemOrderProduct(Product product, Product[] listOfProducts) {
        for (int i = 0; i < listOfProducts.length; i++) {
            listOfProducts[i] = null;
        }
    }

    public static float totalAmountOrder(Product[] listOfProducts) {
        float totalAmount = 0.0f;

        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] != null) {
                totalAmount = totalAmount + listOfProducts[i].getPrise();
            }
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "{Order : [  OrderStatus=" + orderStatus +
                ", TotalAmount=" + totalAmount + ", ListOfProducts=" + Arrays.toString(listOfProducts) + "]}";
    }
}
