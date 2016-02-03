package com.mio.brewdiary.export;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mio.brewdiary.model.Recipe;
import com.mio.brewdiary.web.EMF;


@Path("/recipe")
public class PrimoRestController {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/all")
	public List<Recipe> listAllRecipes() {
		EntityManager em = EMF.createEntityManager();
		try{
			List<Recipe> recipes = em.createQuery("from Recipe r", Recipe.class).getResultList();
			System.out.println(recipes);
			System.out.println(recipes.size());
			return recipes;
		}catch(Throwable t){
			throw t;
		}finally{		
			em.close();
		}
	}
	
	@GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on "+new Date().toString();
    }
	
}
