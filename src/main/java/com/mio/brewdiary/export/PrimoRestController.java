package com.mio.brewdiary.export;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mio.brewdiary.dto.RecipeListItem;
import com.mio.brewdiary.model.Recipe;
import com.mio.brewdiary.service.RecipeService;
import com.mio.brewdiary.service.RecipeServiceImpl;


@Path("/recipe")
public class PrimoRestController {
	
	private RecipeService recipeServ = new RecipeServiceImpl();

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/all")
	public List<RecipeListItem> listAllRecipes() throws Exception {
		return recipeServ.listAllRecipes();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/get/{id}")
	public Recipe getRecipe(@PathParam("id") int id) throws Exception {
		return recipeServ.getRecipe(id);
	}
	
	@GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on "+new Date().toString();
    }
	
}
