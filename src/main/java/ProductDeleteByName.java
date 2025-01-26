import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Product;

import java.util.Scanner;

public class ProductDeleteByName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            System.out.println("Введите название товара, которую нужно удалить: ");
            String productName = scanner.nextLine();

            Product product = entityManager.createQuery("select p from Product p where p.name = :name", Product.class)
                    .setParameter("name", productName)
                    .getSingleResult();
            // не нашли товар
            if (product == null) {
                System.out.println("Товар с таким названием не найден");
                return;
            }
            // нашли товар
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            System.out.printf("Товар %s успешно удален!", productName);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

}