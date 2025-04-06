package com.example.services;

import com.example.models.Competitor;
import com.example.models.CompetitorDTO;
import com.example.PersistenceManager;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import org.json.JSONObject;

@Path("/competitors")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitorService {

    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/get")
    public Response getAll() {
        Query q = entityManager.createQuery("SELECT u FROM Competitor u ORDER BY u.surname ASC");
        List<Competitor> competitors = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompetitor(CompetitorDTO competitor) {
        JSONObject rta = new JSONObject();
        Competitor c = new Competitor(
                competitor.getName(),
                competitor.getSurname(),
                competitor.getAge(),
                competitor.getTelephone(),
                competitor.getCellphone(),
                competitor.getAddress(),
                competitor.getCity(),
                competitor.getCountry(),
                false,
                competitor.getPassword()
        );

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
            entityManager.refresh(c);
            rta.put("competitor_id", c.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toString()).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(CompetitorDTO credentials) {
        try {
            System.out.println("Intentando login con dirección: " + credentials.getAddress() + " y contraseña: " + credentials.getPassword());

            Query q = entityManager.createQuery(
                    "SELECT c FROM Competitor c WHERE c.address = :address AND c.password = :password"
            );
            q.setParameter("address", credentials.getAddress());
            q.setParameter("password", credentials.getPassword());

            List<Competitor> result = q.getResultList();

            if (result.isEmpty()) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Credenciales inválidas").build();
            }

            Competitor logged = result.get(0);
            return Response.status(200).entity(logged).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
