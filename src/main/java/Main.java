import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Category;
import model.Option;
import model.Product;
import model.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//        System.out.println("Список всех категорий: ");
//        List<Category> categories = entityManager.createQuery("from Category", Category.class)
//                .getResultList();
//        // выводим все категории (просто посмотреть)
//        for (Category category : categories) {
//            System.out.println(category.getId() + ". " + category.getName());
//        }
//        // пользователь выбирает категорию
//        System.out.println("Введите id категории: ");
//        int categoryId = Integer.parseInt(scanner.nextLine());
//        // ищем категорию
//        Category category = entityManager.find(Category.class, categoryId);
//        // не нашли категорию
//        if (category == null) {
//            System.out.println("Категория с таким id не найдена!");
//            return;
//        }
//        // или нашли категорию
//        System.out.println("Список всех товаров в категории " + category.getName() + ": ");
//        // список товаров данной категории
//        List<Product> products = entityManager
//                // :categoryId - именованный параметр
//                .createQuery("from Product product where product.category.id = :categoryId", Product.class)
//                // установка переданных значений в параметр
//                .setParameter("categoryId", categoryId)
//                .getResultList();
//        // пустой список
//        if (products.isEmpty()) {
//            System.out.println("Товаров в данной категории не найдено!");
//            // не пустой список
//        } else {
//            // общая стоимость
//            int totalCost = 0;
//            for (Product product : products) {
//                // выводим название продукта и его цену
//                System.out.println(product.getName() + " (" + product.getPrice() + ")");
//                for (Value value : product.getValues()) {
//                    // выводим название характеристики и её значение
//                    System.out.println("- " + value.getOption().getName() + ": " + value.getName());
//                }
//                totalCost += product.getPrice();
//            }
//            System.out.println("Общая стоимость: " + totalCost);
//        }

//entityManager.create
// Получить объект по id
        /*User user = entityManager.find(User.class, 1); // метод для нахождения объекта по id

        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getBirthday());*/

// Получить все объекты
// sql  select * from users
// jpql jakarta persistence query language
// select u from User u
//        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
//        List<User> users = query.getResultList();
//        for (User user : users) {
//            System.out.println(user.getId() + ". " + user.getFirstName());
//        }

// Подготовленные запросы
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя пользователя");
//        String userName = scanner.nextLine();

// Способ через номер
//        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.firstName = ?1", User.class);
//        query.setParameter(1, userName);

// Способ через название
//        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.firstName = :name", User.class);
//        query.setParameter("name", userName);
//
//        User user = query.getSingleResult();
//        System.out.println(user);

//        Optional<User> optional = entityManager.createQuery("select u from User u where u.firstName = :name", User.class)
//                .setParameter("name", userName)
//                .getResultStream()
//                .findFirst();
//        optional.ifPresent(System.out::println);

// Создание объекта (insert)
//        User user = new User();
//        user.setFirstName("userFromJPA");
//        user.setLastName("lastnameFromJPA");
//        user.setBirthday(LocalDate.now());
//
//        try {
//            entityManager.getTransaction().begin(); // открытие транзакции
//
//            entityManager.persist(user);
//            System.out.println(user);
//
//            entityManager.getTransaction().commit(); // закрытие транзакции
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback(); // откат изменении
//            System.out.println(e.getMessage());
//        }

// Обновление объекта (update)
//        User user = entityManager.find(User.class, 4); // находим существующего пользователя
//        user.setFirstName("UPDATED FIRST_NAME");
//
//        try {
//            entityManager.getTransaction().begin(); // открытие транзакции
//
//            entityManager.merge(user);
//            System.out.println(user);
//
//            entityManager.getTransaction().commit(); // закрытие транзакции
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback(); // откат изменении
//            System.out.println(e.getMessage());
//        }

// Удаление объекта (delete)
//        User user = entityManager.find(User.class, 4); // находим существующего пользователя
//
//        try {
//            entityManager.getTransaction().begin(); // открытие транзакции
//
//            entityManager.remove(user);
//            System.out.println(user);
//
//            entityManager.getTransaction().commit(); // закрытие транзакции
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback(); // откат изменении
//            System.out.println(e.getMessage());
//        }
    }
}