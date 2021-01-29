package recette.m2i.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import recette.m2i.models.Ingredient;
import recette.m2i.services.IngredientService;

@RestController
@RequestMapping("ingredients") // localhost:8080/ingredients
public class IngredientController {

	@Autowired
	private IngredientService service;
	
	
	@GetMapping() //localhost:8080/users --> GET 
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}") //localhost:8080/users/un_id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	
	@GetMapping("/nom/{nom}") //localhost:8080/users/nom/un_nom
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findByNomAllIgnoreCase(@PathVariable String nom) {
		return this.service.findByNomAllIgnoreCase(nom);
		}
	
	//CREATE
	@PostMapping() //localhost:8080/users --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return this.service.create(ingredient);
	}
	
	//UPDATE
	@PutMapping("/{id}")  //localhost:8080/users/un_id --> PUT
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient update( @PathVariable String id,@RequestBody Ingredient ingredient) {
		Ingredient oldIngredient = this.service.findById(id);
		ingredient.setId(oldIngredient.getId());
		return this.service.update(ingredient);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		 this.service.delete(id);
	}
}
