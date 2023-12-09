package src.Java20_11_23.Classes.OrderManagementSystem;

public class Product extends OrderManagementSystem {
    String nameProduct;
    float prise;
    int quantityInStock;

    public Product(String nameProduct, float prise, int quantityInStock) {
        this.nameProduct = nameProduct;
        this.prise = prise;
        this.quantityInStock=quantityInStock;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrise() {
        return prise;
    }

    public void setPrise(float prise) {
        this.prise = prise;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public static void availabilityCheck(Product[] products, String nameProduct) {
        for (int i = 0; i < products.length ; i++) {
            if (products[i].nameProduct.equalsIgnoreCase(nameProduct)) {
                if (products[i].quantityInStock <= 0){
                    System.out.println("Product out of stock");
                } else {
                    System.out.println("Only "+products[i].quantityInStock+" left in stock");
                }
                break;
            }
        }
    }

    public static void updatingQuantityInStock(Product product, int additive, Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].nameProduct.equalsIgnoreCase(product.nameProduct)) {
                products[i].quantityInStock += additive;
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "{Product " +
                "NameProduct= " + nameProduct + ", Prise= " + prise + ", QuantityInStock= " + quantityInStock+"}";
    }
}
