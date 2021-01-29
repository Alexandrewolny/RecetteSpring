package recette.m2i.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import recette.m2i.models.Categorie;

public interface CategorieRepository extends MongoRepository<Categorie,String> {
	
	public List<Categorie> findByNomAllIgnoreCase(String nom);


	

}
