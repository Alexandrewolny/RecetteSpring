package recette.m2i.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Categorie {

	@Id
	private String id;
	private String nom;
	
	public Categorie() {
		
	}

	public Categorie(String id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	
}
