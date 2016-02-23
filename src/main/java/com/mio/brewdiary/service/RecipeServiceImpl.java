package com.mio.brewdiary.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mio.brewdiary.dto.RecipeListItem;
import com.mio.brewdiary.model.Brewer;
import com.mio.brewdiary.model.Hop;
import com.mio.brewdiary.model.Malt;
import com.mio.brewdiary.model.Recipe;
import com.mio.brewdiary.model.Spice;
import com.mio.brewdiary.web.EMF;

public class RecipeServiceImpl implements RecipeService {
	
	static Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Override
	public Recipe getRecipe(int id) throws Exception{
		EntityManager em = EMF.createEntityManager();
		return em.find(Recipe.class, id);
	}

	@Override
	public List<RecipeListItem> listAllRecipes() throws Exception {
		EntityManager em = EMF.createEntityManager();
		List<Recipe> recipes = em.createQuery("from Recipe r", Recipe.class).getResultList();
		logger.debug("found {} recipes",recipes.size());
		List<RecipeListItem> items = new ArrayList<RecipeListItem>(recipes.size());
		for (Recipe r : recipes) {
			RecipeListItem i = new RecipeListItem();
			i.setExpectedFG(r.getExpectedFG());
			i.setExpectedOG(r.getExpectedOG());
			i.setId(r.getId());
			i.setName(r.getName());
			i.setYeastType(r.getYeast().getType().getName());
			i.setStyle(r.getStyle().getName());
			i.setCookedTimes(4);
			for (Hop h : r.getHops()) {
				if(! i.getHopTypes().contains(h.getType().getName())){
					i.getHopTypes().add(h.getType().getName());
				}
			}
			for(Malt m : r.getMalts()){
				if(! i.getMaltTypes().contains(m.getType().getName())){
					i.getMaltTypes().add(m.getType().getName());
				}
			}
			for(Spice s : r.getSpices()){
				if(! i.getSpiceTypes().contains(s.getType().getName())){
					i.getSpiceTypes().add(s.getType().getName());
				}
			}
			
			items.add(i);
		}
		logger.debug("found {} recipes",items.size());
		return items;
	}
	
	
	@Override
	public Brewer login(String username, String password) throws Exception{
		EntityManager em = EMF.createEntityManager();
		List<Brewer> brewers = em.createQuery("from Brewer b where b.username=:n and b.password=:p", Brewer.class)
			.setParameter("n", username)
			.setParameter("p", password)
			.getResultList();
		
		if(brewers!=null && brewers.size()>0){
			return brewers.get(0);
		}
		
		return null;
	}
	
	
	@Override
	public Brewer regUser(Brewer b) throws Exception{
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		logger.debug("registered brewer {} with id {}",b.getName(),b.getId());
		return b;
	}

}
