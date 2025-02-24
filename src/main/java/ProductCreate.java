import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Category;
import model.Option;
import model.Product;
import model.Value;

import java.util.List;
import java.util.Scanner;

public class ProductCreate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        // сначала сообразим категорию товара
        System.out.println("Список всех категорий: ");
        List<Category> categories = entityManager.createQuery("from Category", Category.class)
                .getResultList();

        for (Category category : categories) {
            System.out.println(category.getId() + ". " + category.getName());
        }

        System.out.println("Введите id категории: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        Category category = entityManager.find(Category.class, categoryId);
        // не нашли категорию
        if (category == null) {
            System.out.println("Категория с таким id не найдена!");
            return;
        }
        // нашли категорию
        try {
            entityManager.getTransaction().begin();

            System.out.println("Введите название товара: ");
            String productName = scanner.nextLine();

            System.out.println("Введите стоимость товара:");
            double price = Double.parseDouble(scanner.nextLine());

            // формируем товар
            Product product = new Product();
            product.setName(productName);
            product.setPrice(price);
            product.setCategory(category);

            // чтобы ввести values (нам нужно из-за наличия списка), нам нужны options
            List<Option> options = category.getOptions();
            for (Option option : options) {
                System.out.println(option.getName() + ": ");
                // вводим значения для характеристик
                String valueName = scanner.nextLine();
                // формируем значения
                Value value = new Value();
                value.setName(valueName);
                value.setProduct(product);
                value.setOption(option);
                // сохраняем значение
                entityManager.persist(value);
                // добавляем значения в список
                product.getValues().add(value);
            }

            // сохраняем товар
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            System.out.println("Товар успешно внесён в таблицу!");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

}