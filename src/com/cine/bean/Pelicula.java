package com.cine.bean;

public class Pelicula {
    private int idPelicula;
    private String nombrePel;
    private String sinopsisPel;
    private char categoriaPel;
    private String idiomaPel;

    // Getters y Setters
    public int getIdPelicula() {
        return idPelicula;
    }
    
    public String getNombrePel() {
        return nombrePel;
    }

    public String getSinopsisPel() {
        return sinopsisPel;
    }

    public char getCategoriaPel() {
        return categoriaPel;
    }

    public String getIdiomaPel() {
        return idiomaPel;
    }

    private Pelicula(Builder builder) {
        this.idPelicula = builder.idPelicula;
        this.nombrePel = builder.nombrePel;
        this.sinopsisPel = builder.sinopsisPel;
        this.categoriaPel = builder.categoriaPel;
        this.idiomaPel = builder.idiomaPel;
    }

    public static class Builder {
        private int idPelicula;
        private String nombrePel;
        private String sinopsisPel;
        private char categoriaPel;
        private String idiomaPel;

        public Builder idPelicula(int idPelicula) {
            this.idPelicula = idPelicula;
            return this;
        }

        public Builder nombrePel(String nombrePel) {
            this.nombrePel = nombrePel;
            return this;
        }

        public Builder sinopsisPel(String sinopsisPel) {
            this.sinopsisPel = sinopsisPel;
            return this;
        }

        public Builder categoriaPel(char categoriaPel) {
            this.categoriaPel = categoriaPel;
            return this;
        }

        public Builder idiomaPel(String idiomaPel) {
            this.idiomaPel = idiomaPel;
            return this;
        }

        public Pelicula build() {
            return new Pelicula(this);
        }
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", nombrePel='" + nombrePel + '\'' +
                ", sinopsisPel='" + sinopsisPel + '\'' +
                ", categoriaPel=" + categoriaPel +
                ", idiomaPel='" + idiomaPel + '\'' +
                '}';
    }
}
