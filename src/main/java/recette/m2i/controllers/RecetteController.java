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
import recette.m2i.models.Recette;
import recette.m2i.services.RecetteService;

@RestController
@RequestMapping("recettes")
public class RecetteController {

	@Autowired
	private RecetteService rservice;
	
	
	@GetMapping() //localhost:8080/users --> GET 
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findAll() {
		return this.rservice.getAll();
	}
	
	@GetMapping("/{id}") //localhost:8080/users/un_id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.rservice.findById(id);
	}
	
	
	@GetMapping("/nom/{nom}") //localhost:8080/users/nom/un_nom
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByNomAllIgnoreCase(@PathVariable String nom) {
		return this.rservice.findByNomAllIgnoreCase(nom);
		}
	
	//CREATE
	@PostMapping() //localhost:8080/users --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recette create(@RequestBody Recette recette) {
		return this.rservice.create(recette);
	}
	
	//UPDATE
	@PutMapping("/{id}")  //localhost:8080/users/un_id --> PUT
	@ResponseStatus(code = HttpStatus.OK)
	public Recette update( @PathVariable String id,@RequestBody Recette recette) {
		Recette oldRecette = this.rservice.findById(id);
		recette.setId(oldRecette.getId());
		return this.rservice.update(recette);
		
	}
	
	@GetMapping("/categorie/{nom}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findByCategorie(@PathVariable Categorie nom, @RequestBody Recette recette) {
		
		return recette;
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		 this.rservice.delete(id);
	}
}
