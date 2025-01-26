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
            // вводим название новой категории
            System.out.println("Введите название категории: ");
            String categoryScanner = scanner.nextLine();
            Category category = new Category();
            category.setName(categoryScanner);
            // сохраняем новую категорию
            entityManager.persist(category);

            // вводим новые хаарктеристики
            System.out.println("Введите названия характеристик (через запятую): ");
            String optionScanner = scanner.nextLine();
            String[] optionNames = optionScanner.split(",\\s*");

            // формируем характеристику
            for (String optionName : optionNames) {
                Option option = new Option();
                option.setName(optionName);
                // ссылка на уже сохранённую категорию
                option.setCategory(category);
                // сохраняем характеристику
                entityManager.persist(option);
            }

            entityManager.getTransaction().commit();
            System.out.println("Категория успешно создана!");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}