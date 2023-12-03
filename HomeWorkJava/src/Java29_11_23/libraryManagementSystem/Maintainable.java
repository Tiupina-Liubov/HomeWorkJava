package Java29_11_23.libraryManagementSystem;

public interface Maintainable {
    void repairItem();
    void updateItemCondition(ItemCondition condition);
    ItemCondition checkCondition();
}
