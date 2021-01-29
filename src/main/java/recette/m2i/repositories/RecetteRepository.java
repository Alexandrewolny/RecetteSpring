package recette.m2i.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import recette.m2i.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String> {

	public List<Recette> findByNomAllIgnoreCase(String nom);

}
