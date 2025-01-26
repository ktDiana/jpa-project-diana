import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Category;
import model.Option;
import java.util.Scanner;

public class CategoryCreate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            System.out.println("Введите название категории: ");
            String categoryScanner = scanner.nextLine();
            Category category = new Category();
            category.setName(categoryScanner);

            entityManager.persist(category);

            System.out.println("Введите названия характеристик (через запятую): ");
            String optionScanner = scanner.nextLine();
            String[] optionNames = optionScanner.split(",\\s*");

            for (String optionName : optionNames) {
                Option option = new Option();
                option.setName(optionName);
                option.setCategory(category); // Ссылка на уже сохранённую категорию
                entityManager.persist(option); // Сохраняем каждую характеристику
            }

            entityManager.getTransaction().commit();
            System.out.println("Категория создана вместе с характеристиками!");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}