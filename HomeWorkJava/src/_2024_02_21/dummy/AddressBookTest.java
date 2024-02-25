package src._2024_02_21.dummy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AddressBookTest {

    public Customer createCustomer() {
        State state = new State("NY");
        City city = new City("NY", state);
        Address address = new Address("M drive 25", city);
        return new Customer("F", "L", address);
    }

    @Test
    void addCustomerE1PositiveTest() {
        Customer customer = createCustomer();
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(customer);
        Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
    }

    @Test
    void addCustomerE2NullPoinerExceptionTest() {
        Customer customer = null;
        AddressBook addressBook = new AddressBook();
        Assertions.assertThrows(NullPointerException.class,
                ()->   addressBook.addCustomer(customer));
    }

    @Test
    void addCustomerE3Dummy() {
        Customer customer = Mockito.mock(Customer.class);
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(customer);
        Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
    }
}