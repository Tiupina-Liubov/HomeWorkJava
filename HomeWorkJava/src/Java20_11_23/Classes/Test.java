package src.Java20_11_23.Classes;

import src.Java20_11_23.Classes.Library.Book;
import src.Java20_11_23.Classes.Library.Librarian;
import src.Java20_11_23.Classes.Library.Library;
import src.Java20_11_23.Classes.Library.Reader;
import src.Java20_11_23.Classes.OrderManagementSystem.Customer;
import src.Java20_11_23.Classes.OrderManagementSystem.Order;
import src.Java20_11_23.Classes.OrderManagementSystem.OrderManager;
import src.Java20_11_23.Classes.OrderManagementSystem.Product;
import src.Java20_11_23.Classes.TransportFleetManagementSystem.Car;
import src.Java20_11_23.Classes.TransportFleetManagementSystem.Driver;
import src.Java20_11_23.Classes.TransportFleetManagementSystem.Fleet;
import src.Java20_11_23.Classes.TransportFleetManagementSystem.FleetManager;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //      1 уровень сложности: - Инвертировать массив, то есть изменить порядок
//         элементов в массиве на обратный.
        int[] a = {11, 2, 13, 7, 15, 16, 17, 1, 19, 9, 10};
        System.out.println(Arrays.toString(invertArray(a)));
//        Поиск третьего по величине числа в массиве
        System.out.println(thirdLargest(a));
        System.out.println(thirdLargestSort(a));
        //       Скомпоновать классы:
//        Управление Библиотекой.
//        Классы:
//        Книга (Book)
//        Поля: название, автор, год издания.
//        Методы: вывод информации о книге, проверка на старинность (старше 50 лет).
        Book book = new Book("Dune", "Frank Herbert", 1965);
        Book book1 = new Book("Marginalia", "H. P. Lovecraft", 2020);
        Book book2 = new Book("The Crawling Chaos and Others", "H. P. Lovecraft", 2011);
        Book book3 = new Book("The Crawling Chaos ", "H. P. Lovecraft", 2010);
        Book book4 = new Book("Hunger", "H. P. Lovecraft", 1950);
        Book book5 = new Book("Others", "H. P. Lovecraft", 1975);

        System.out.println(Book.displayInformationAboutHheBook(book));
        System.out.println(Book.displayInformationAboutHheBook(book1));
        System.out.println(Book.displayInformationAboutHheBook(book2));
        System.out.println(Book.antiquityCheck(book));
        System.out.println(Book.antiquityCheck(book2));
//        Читатель (Reader)
//        Поля: имя, возраст, список взятых книг (массив).
//        Методы: взять книгу, вернуть книгу.
        Reader reader = new Reader("Liubov Tiupina", 30);
        Reader.takeABook(reader, book);
        Reader.takeABook(reader, book1);
        Reader.takeABook(reader, book2);
        System.out.println(Arrays.toString(reader.getTakingABook()));
        Reader.returnABook(reader, book);
        System.out.println(Arrays.toString(reader.getTakingABook()));
//        Библиотекарь (Librarian)
//        Поля: имя, стаж работы, список доступных книг (массив).
//        Методы: выдать книгу читателю, принять книгу от читателя.
        Librarian librarian = new Librarian("Pitrova Anna", 12);
        Librarian librarian1 = new Librarian("Smirnova Tanny", 10);
        Librarian librarian2 = new Librarian("Tiupina Liubov", 5);
        Librarian librarian3 = new Librarian("Bolkov Kolja", 1);
        Book[] listOfAvailableBooks = {book, book3, book4, book5, null, null, null, null, null, null,};
        librarian.setListOfAvailableBooks(listOfAvailableBooks);
        librarian.issueABook(reader, book);
        librarian.returnBook(reader, book);
//        Библиотека (Library)
//        Поля: название, адрес, список библиотекарей (массив).
//        Методы: добавить библиотекаря, найти библиотекаря по имени.
        Librarian[] librarians = {librarian, librarian1, librarian2, librarian3, null, null};
        String name = "Tiupina Liubov";
        System.out.println(Library.findALibrarianByName(librarians, name));
        Librarian librarian4 = new Librarian("Pupkin Sascha", 5);
        Library.addLibrarian(librarian3, librarian);
        System.out.println(librarian);
        //        Система Управления Заказами
//        Классы:
//        Товар (Product)
//        Поля: название, цена, количество на складе.
//        Методы: проверка наличия, обновление количества на складе.
        Product product = new Product("Phone 6", 500.0f, 8);
        Product product1 = new Product("Phone 8", 700.50f, 11);
        Product product2 = new Product("Phone 12", 800.50f, 0);
        Product product3 = new Product("Phone 13Pro", 1060.0f, 1);
        Product[] products = {product, product1, product2, product3, null, null, null, null};
        String nameProduct = "Phone 12";
        String nameProduct1 = "Phone 6";
        Product.availabilityCheck(products, nameProduct);
        Product.availabilityCheck(products, nameProduct1);
        int add = 7;
        Product.updatingQuantityInStock(product2, add, products);
        System.out.println(product2.getQuantityInStock());
        System.out.println(product2);
//        Заказ (Order)
//        Поля: список товаров (массив), статус заказа, общая сумма.
//        Методы: добавить товар в заказ, рассчитать общую сумму
        Product[] productsOrder = new Product[20];
        Order.addItemOrderProduct(product, productsOrder);
        Order.addItemOrderProduct(product1, productsOrder);
        System.out.println(Arrays.toString(productsOrder));
        System.out.println(Order.totalAmountOrder(productsOrder));
//        Клиент (Customer)
//        Поля: имя, email, история заказов (массив).
//        Методы: сделать заказ, отменить заказ.
        Customer customer = new Customer("Tiupina Liubov", "kyzjaxxx93@gmail.com");
        Customer customer1 = new Customer("Tiupina Tannja", "kyzjaxxx93@gmail.com");
        Customer customer2 = new Customer("Tiupin Volodimir", "kyzjaxxx93@gmail.com");
        System.out.println(customer2);
        System.out.println("__________");
        Order order = customer2.addOrder(product, product3, product1, product2);
        Order order1 = customer2.addOrder(product, product3, product1, product2);
        Order order2 = customer1.addOrder(product, product3, product1, product2);
        Order order3 = customer.addOrder(product, product3, product1, product2);
        System.out.println(order);
        customer2.addOrder(product2, product1);
        customer1.removeOrder(order);
        System.out.println(order);
//      Менеджер Заказов (OrderManager)
//      Поля: список доступных товаров (массив), список заказов (массив).
//      Методы: обработка нового заказа, обновление статуса заказа.
        OrderManager orderManager = new OrderManager();
        orderManager.getListNewOrders();
        orderManager.newOrders(orderManager.getListNewOrders(), order1, order, order2, order3);
        System.out.println(orderManager);
        orderManager.setListProductsInStock(products);
        // orderManager.newOrderProcessing(orderManager.getListNewOrders(),orderManager.getListProductsInStock());(С этим что-то пошло не так простите!)
//        Система Управления Транспортным Парком
//        Классы:
//        Автомобиль (Car)
//        Поля: марка, модель, год выпуска.
//        Методы: вывод информации об автомобиле, проверка на техосмотр.
        Car car = new Car("Audi", "X6", 2016);
        Car car1 = new Car("Audi", "X8", 2019);
        Car[] cars = {car1, null, null, null, null};
        car1.setTechnicalInspection(true);
        System.out.println(car1.carInformation());
        Car.technicalInspection(car);
        Car.technicalInspection(car1);
//        Водитель (Classes.TransportFleetManagementSystem.Driver)
//        Поля: имя, стаж вождения, текущий автомобиль (Car).
//        Методы: назначить автомобиль, освободить автомобиль.
        Driver driver = new Driver("liubov Tiupina");
        driver.assignCar(car);
        driver.releaseCar(car);
//        Менеджер Парка (FleetManager)
//        Поля: имя, список автомобилей (массив), список водителей (массив).
//        Методы: добавить автомобиль в парк, назначить автомобиль водителю.
        FleetManager fleetManager = new FleetManager("Vitalk Skut");
        fleetManager.addCarToFleet(car, cars);
        System.out.println(Arrays.toString(cars));
        System.out.println(driver);
        fleetManager.assignCarDriver(driver, car1);
        System.out.println(driver);
        fleetManager.releaseCarDriver(driver, car1);
        System.out.println(driver);
//        Транспортный Парк (Fleet)
//        Поля: название, адрес, список менеджеров парка (массив).
//        Методы: добавить менеджера, поиск менеджера по имени.
        Fleet fleet = new Fleet("Fleet");
        fleet.addFleetManager(fleetManager);
        String manager = "Vitalk Skut";
        fleet.searchManagerName(manager);
        fleet.removeFleetManager(fleetManager);
        System.out.println(Arrays.toString(fleet.getFleetManagersFleet()));
    }

    private static int[] invertArray(int[] array) {
        int change;
        int end = array[array.length - 1];
        if (array.length % 2 == 0) {
            for (int i = 0; i < array.length / 2; i++) {
                change = array[i];
                array[i] = array[end];
                array[end] = change;
                end--;
            }
        } else {
            for (int i = 0; i < (array.length / 2) + 1; i++) {
                change = array[i];
                array[i] = array[end];
                array[end] = change;
                end--;
            }
        }
        return array;
    }

    private static int thirdLargest(int[] array) {
        int min = array[0];
        int second = 0;
        int third = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                third = second;
                second = min;
                min = array[i];
            } else if (array[i] < second) {
                third = second;
                second = array[i];
            } else if (array[i] < third) {
                third = array[i];
            }
        }
        return third;
    }

    private static int thirdLargestSort(int[] array) {
        Arrays.sort(array);
        int thirdIndex = array[2];
        return thirdIndex;


    }
}