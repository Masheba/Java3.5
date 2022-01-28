package Manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void shouldSearchBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book2 = new Book(2, "Гарри Поттер", 890, "Джоан Роулинг");
        Book book3 = new Book(3, "Sapiens. Краткая история человечества", 1500, "Харари");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Игра престолов");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book2 = new Book(2, "Гарри Поттер", 890, "Джоан Роулинг");
        Book book3 = new Book(3, "Sapiens. Краткая история человечества", 1500, "Харари");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Харари");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSeveralBooksByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book2 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book3 = new Book(3, "Sapiens. Краткая история человечества", 1500, "Харари");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Игра престолов");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 83000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Oppo", 13999, "BBK");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSeveralSmartphonesByProducer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 83000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Iphone 3", 13999, "Apple");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book2 = new Book(2, "Iphone", 890, "Джоан Роулинг");
        Book book3 = new Book(3, "Sapiens. Краткая история человечества", 1500, "Харари");
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 83000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Oppo", 13999, "BBK");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{book2, smartphone1};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBookByID() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Игра престолов", 543, "Джордж Мартин");
        Book book2 = new Book(2, "Гарри Поттер", 890, "Джоан Роулинг");
        Book book3 = new Book(3, "Sapiens. Краткая история человечества", 1500, "Харари");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Гарри Поттер");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }


}