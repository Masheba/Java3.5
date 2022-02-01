package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Book first = new Book(1, "Игра престолов", 543, "Джордж Мартин");
    private Smartphone second = new Smartphone(2, "Oppo", 13999, "BBK");
    private Book third = new Book(3, "Гарри Поттер", 890, "Джоан Роулинг");
    private Smartphone fourth = new Smartphone(4, "Iphone", 83000, "Apple");
    private Book fifth = new Book(5, "Sapiens. Краткая история человечества", 1500, "Харари");
    private Smartphone sixth = new Smartphone(6, "Honor 10", 19333, "Huawei");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("Игра престолов");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("Харари");
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByProducer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchBook() {
        Product[] actual = manager.searchBy("Ник Перумов");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoеMatchSmartphone() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

}