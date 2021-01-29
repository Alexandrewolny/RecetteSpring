package recette.m2i.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Ingredient {
	
	@Id
	private String id;
	private String nom;
	private int quantite;
	private String unite;
	
	public Ingredient() {
		
	}

	public Ingredient(String id, String nom, int quantite, String unite) {
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}
	
	
	
}
