package com.cine.bean;

public class Pelicula {
	private int idPelicula;
	private String nombrePel;
	private String sinopsisPel;
	private char categoriaPel;
	private String idiomaPel;

	public Pelicula(int idPelicula, String nombrePel, String sinopsisPel, char categoriaPel, String idiomaPel) {
		super();
		this.idPelicula = idPelicula;
		this.nombrePel = nombrePel;
		this.sinopsisPel = sinopsisPel;
		this.categoriaPel = categoriaPel;
		this.idiomaPel = idiomaPel;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombrePel() {
		return nombrePel;
	}

	public void setNombrePel(String nombrePel) {
		this.nombrePel = nombrePel;
	}

	public String getSinopsisPel() {
		return sinopsisPel;
	}

	public void setSinopsisPel(String sinopsisPel) {
		this.sinopsisPel = sinopsisPel;
	}

	public char getCategoriaPel() {
		return categoriaPel;
	}

	public void setCategoriaPel(char categoriaPel) {
		this.categoriaPel = categoriaPel;
	}

	public String getIdiomaPel() {
		return idiomaPel;
	}

	public void setIdiomaPel(String idiomaPel) {
		this.idiomaPel = idiomaPel;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombrePel=" + nombrePel + ", sinopsisPel=" + sinopsisPel
				+ ", categoriaPel=" + categoriaPel + ", idiomaPel=" + idiomaPel + "]";
	}

}
