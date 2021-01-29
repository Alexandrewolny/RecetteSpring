package recette.m2i.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import recette.m2i.models.Recette;
import recette.m2i.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired
	private RecetteRepository repository;
	
	public List<Recette> getAll() {
		return this.repository.findAll();
	}

	public Recette findById(String id) {
		// Retourne un optional ( on est pas sur de trouver un user)
		return this.repository.findById(id)
				// sinon on demande de lancer 
				.orElseThrow(
						// une fonction lambda / anonyme / closure
						// qui retourne une exception HTTP
						()->new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}
	
	public List<Recette> findByNomAllIgnoreCase(@PathVariable String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
		}
	
	public Recette create(@RequestBody Recette recette) {
		return this.repository.insert(recette);
	}
	
	
	public Recette update(@RequestBody Recette recette) {
		return this.repository.save(recette);
	}
	
	public void delete(@PathVariable String id) {
		 this.repository.deleteById(id);
	}
}
