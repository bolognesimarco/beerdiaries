package com.mio.brewdiary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mio.brewdiary.model.Brewer;
import com.mio.brewdiary.service.RecipeService;
import com.mio.brewdiary.service.RecipeServiceImpl;

public class RecipeServiceTest {
	
	private RecipeService service = null;
	
	@Before
	public void setUp(){
		System.setProperty("test.dal.mio.pc", "OK");
		service = new RecipeServiceImpl();		
	}
	
	@Test
	public void testSearchBrewer() throws Exception{
		Brewer b = service.login("a", "a");
		
		Assert.assertNotNull("BREWER NOT FOUND.", b);
	}

}
