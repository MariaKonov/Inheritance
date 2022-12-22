package Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {

    @Test
    public void idTest() {
        Book book = new Book(76, "Glow", 250, "Stephen Edwin King");

        int expected = 76;
        int actual = book.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void authorTest() {
        Book book = new Book(76, "Glow", 250, "Stephen Edwin King");

        String expected = "Stephen Edwin King";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void vendorTest() {
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");
        ;

        String expected = "Apple";
        String actual = phone.getvendor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceTest() {

        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        int expected = 87_000;
        int actual = phone.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestWhenOneProductIsFound() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Glow", 250, "Stephen Edwin King");
        Book book2 = new Book(77, "The dark tower", 300, "Stephen Edwin King");
        Book book3 = new Book(78, "It", 500, "Stephen Edwin King");
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Glow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestWhenFewProductsFound() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Один дома 1", 250, "Chris Columbus");
        Book book2 = new Book(77, "Один дома 2", 300, "Chris Columbus");
        Book book3 = new Book(78, "It", 500, "Stephen Edwin King");
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("дома");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestWhenDeletingProducts() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Один дома 1", 250, "Chris Columbus");
        Book book2 = new Book(77, "Один дома 2", 300, "Chris Columbus");
        Book book3 = new Book(78, "It", 500, "Stephen Edwin King");
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(phone);

        Product[] expected = {book1, book2, phone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllById() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Один дома 1", 250, "Chris Columbus");
        Book book2 = new Book(77, "Один дома 2", 300, "Chris Columbus");
        Book book3 = new Book(78, "It", 500, "Stephen Edwin King");
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone);
        repo.removeById(76);
        repo.removeById(77);
        repo.removeById(78);
        repo.removeById(5);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkWhenThereAreZeroProducts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Один дома 1", 250, "Chris Columbus");
        Book book2 = new Book(77, "Один дома 2", 300, "Chris Columbus");
        Book book3 = new Book(78, "It", 500, "Stephen Edwin King");
        Smartphone phone = new Smartphone(5, "Phone 11", 87_000, "Apple");

        Product[] expected = {};
        Product[] actual = manager.searchBy("Один дома 4");

        Assertions.assertArrayEquals(expected, actual);
    }
}
