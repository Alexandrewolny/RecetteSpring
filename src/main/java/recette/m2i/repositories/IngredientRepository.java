package recette.m2i.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import recette.m2i.models.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

	public List<Ingredient> findByNomAllIgnoreCase(String nom);

}
