package recette.m2i.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class Recette {

	@Id
	private String id;
	private String nom;
	
	@DBRef
	private List<Ingredient> ingredients;
	private List<Categorie> categories;
	private String description;
	
	public Recette() {
		
	}

	public Recette(String id, String nom, List<Ingredient> ingredients, List<Categorie> categories,
			String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.ingredients = ingredients;
		this.categories = categories;
		this.description = description;
	}
	
	
}