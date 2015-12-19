package com.projet.entites;

public class Book {
	private String isbn, titre, auteur;

	public Book()
	{
		this("","","");
	}
	public Book(String isbn, String titre, String auteur) {
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book)
			return this.isbn.equalsIgnoreCase(((Book)obj).isbn);
		return false;
	}
	
}
