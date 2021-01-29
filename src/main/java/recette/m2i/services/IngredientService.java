package recette.m2i.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import recette.m2i.models.Ingredient;
import recette.m2i.repositories.IngredientRepository;


@Service
public class IngredientService {
@Autowired private IngredientRepository repository;
	
	public List<Ingredient> getAll() {
		return this.repository.findAll();
	}

	public Ingredient findById(String id) {
		// Retourne un optional ( on est pas sur de trouver un user)
		return this.repository.findById(id)
				// sinon on demande de lancer 
				.orElseThrow(
						// une fonction lambda / anonyme / closure
						// qui retourne une exception HTTP
						()->new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}
	
	public List<Ingredient> findByNomAllIgnoreCase(@PathVariable String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
		}
	
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return this.repository.insert(ingredient);
	}
	
	
	public Ingredient update(@RequestBody Ingredient ingredient) {
		return this.repository.save(ingredient);
	}
	
	public void delete(@PathVariable String id) {
		 this.repository.deleteById(id);
	}
}
