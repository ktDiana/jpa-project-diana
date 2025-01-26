import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Category;
import model.Option;
import model.Product;
import model.Value;

import java.util.Scanner;

public class ProductUpdate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        try {
            System.out.println("Введите ID товара: ");
            int productId = Integer.parseInt(scanner.nextLine());

            Product product = entityManager.find(Product.class, productId);
            if (product == null) {
                System.out.println("Товар с таким ID не найден!");
                return;
            }

            Category category = product.getCategory();
            if (category == null || category.getOptions().isEmpty()) {
                System.out.println("Для данного товара характеристики не найдены");
                return;
            }

            entityManager.getTransaction().begin();

            for (Option option : category.getOptions()) {
                System.out.printf("Введите значение для характеристики %s: ", option.getName());
                String valueName = scanner.nextLine();

                Value value = new Value();
                value.setName(valueName);
                value.setProduct(product);
                value.setOption(option);

                product.getValues().add(value);

                entityManager.persist(value);
            }

            entityManager.getTransaction().commit();

            System.out.println("Значения характеристик товара успешно обновлены!");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}