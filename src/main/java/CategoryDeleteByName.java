import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Category;

import java.util.Scanner;

public class CategoryDeleteByName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            System.out.println("Введите название категории, которую нужно удалить: ");
            String categoryName = scanner.nextLine();

            Category category = entityManager.createQuery("select c from Category c where c.name = :name", Category.class)
                    .setParameter("name", categoryName)
                    .getSingleResult();

            if (category == null) {
                System.out.println("Категория с таким названием не найдена");
                return;
            }

            entityManager.remove(category);
            entityManager.getTransaction().commit();

            System.out.printf("Категория %s успешно удалена!", categoryName);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

}