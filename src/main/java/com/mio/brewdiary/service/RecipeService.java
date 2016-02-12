package com.mio.brewdiary.service;

import java.util.List;

import com.mio.brewdiary.dto.RecipeListItem;
import com.mio.brewdiary.model.Brewer;
import com.mio.brewdiary.model.Recipe;

public interface RecipeService {
	
	public List<RecipeListItem> listAllRecipes() throws Exception;
	public Recipe getRecipe(int id) throws Exception;
	public Brewer regUser(Brewer b) throws Exception;

}
