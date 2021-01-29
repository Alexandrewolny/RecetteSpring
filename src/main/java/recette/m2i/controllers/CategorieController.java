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

import recette.m2i.models.Categorie;
import recette.m2i.models.Ingredient;
import recette.m2i.services.CategorieService;
import recette.m2i.services.IngredientService;

@RestController
@RequestMapping("categories") 
public class CategorieController {
	@Autowired
	private CategorieService service;
	
	
	@GetMapping() //localhost:8080/users --> GET 
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}") //localhost:8080/users/un_id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	
	@GetMapping("/nom/{nom}") //localhost:8080/users/nom/un_nom
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findByNomAllIgnoreCase(@PathVariable String nom) {
		return this.service.findByNomAllIgnoreCase(nom);
		}
	
	//CREATE
	@PostMapping() //localhost:8080/users --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categorie create(@RequestBody Categorie categorie) {
		return this.service.create(categorie);
	}
	
	//UPDATE
	@PutMapping("/{id}")  //localhost:8080/users/un_id --> PUT
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie update( @PathVariable String id,@RequestBody Categorie categorie) {
		Categorie oldCategorie = this.service.findById(id);
		categorie.setId(oldCategorie.getId());
		return this.service.update(categorie);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		 this.service.delete(id);
	}
}
