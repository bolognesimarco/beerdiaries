package com.mio.brewdiary.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mio.brewdiary.dto.RecipeListItem;
import com.mio.brewdiary.model.Hop;
import com.mio.brewdiary.model.Malt;
import com.mio.brewdiary.model.Recipe;
import com.mio.brewdiary.model.Spice;
import com.mio.brewdiary.web.EMF;

public class RecipeServiceImpl implements RecipeService {
	
	@Override
	public Recipe getRecipe(int id) throws Exception{
		EntityManager em = EMF.createEntityManager();
		return em.find(Recipe.class, id);
	}

	@Override
	public List<RecipeListItem> listAllRecipes() throws Exception {
		EntityManager em = EMF.createEntityManager();
		List<Recipe> recipes = em.createQuery("from Recipe r", Recipe.class).getResultList();
		List<RecipeListItem> items = new ArrayList<RecipeListItem>(recipes.size());
		for (Recipe r : recipes) {
			RecipeListItem i = new RecipeListItem();
			i.setExpectedFG(r.getExpectedFG());
			i.setExpectedOG(r.getExpectedOG());
			i.setId(r.getId());
			i.setName(r.getName());
			i.setYeastType(r.getYeast().getType().getName());
			for (Hop h : r.getHops()) {
				i.getHopTypes().add(h.getType().getName());
			}
			for(Malt m : r.getMalts()){
				i.getMaltTypes().add(m.getType().getName());
			}
			for(Spice s : r.getSpices()){
				i.getSpiceTypes().add(s.getType().getName());
			}
			
			items.add(i);
		}
		return items;
	}

}
