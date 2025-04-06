package com.example;

import com.example.models.Competitor;
import com.example.models.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";

        // Inicia la persistencia
        EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        // Crear competidor
        Competitor c = new Competitor(
                "Laura",
                "Rodríguez",
                25,
                "1234567",
                "3001234567",
                "laura@gmail.com",
                "Bogotá",
                "Colombia",
                false,
                "abc123"
        );

        // Crear productos
        Producto p1 = new Producto("Computador", 2500.0, c);
        Producto p2 = new Producto("Impresora", 800.0, c);

        // Agregar productos al competidor
        c.getProductos().addAll(Arrays.asList(p1, p2));

        // Persistir todo
        em.getTransaction().begin();
        em.persist(c); // Se persisten los productos automáticamente por Cascade.ALL
        em.getTransaction().commit();

        em.close();

        System.out.println("Competidor con productos guardado exitosamente.");
    }
}
