package com.mio.brewdiary.service;

import java.util.List;

import com.mio.brewdiary.dto.RecipeListItem;
import com.mio.brewdiary.model.Recipe;

public interface RecipeService {
	
	public List<RecipeListItem> listAllRecipes() throws Exception;
	public Recipe getRecipe(int id) throws Exception;

}
