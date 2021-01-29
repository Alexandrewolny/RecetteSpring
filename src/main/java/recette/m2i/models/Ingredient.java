package recette.m2i.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Ingredient {
	
	@Id
	private String id;
	private String nom;
	private int quatite;
	private int unite;
	
	public Ingredient() {
		
	}

	public Ingredient(String id, String nom, int quatite, int unite) {
		this.id = id;
		this.nom = nom;
		this.quatite = quatite;
		this.unite = unite;
	}
	
	
	
}
