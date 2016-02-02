package com.mio.brewdiary.export;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mio.brewdiary.model.Recipe;

@RestController
public class PrimoRestController {

	@RequestMapping(value="/recipe/", RequestMethod.GET)
	public ResponseEntity<List<Recipe>> listAllRecipes() {
		return null;
	}
	
}
