package com.cine.bean;

public class Sala {
    private int idSala;
    private String nombreSala;
    private int capacidadColumnaSala;
    private int capacidadFilaSala;

    // Getters y Setters
    public int getIdSala() {
        return idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public int getCapacidadColumnaSala() {
        return capacidadColumnaSala;
    }

    public int getCapacidadFilaSala() {
        return capacidadFilaSala;
    }

    private Sala(Builder builder) {
        this.idSala = builder.idSala;
        this.nombreSala = builder.nombreSala;
        this.capacidadColumnaSala = builder.capacidadColumnaSala;
        this.capacidadFilaSala = builder.capacidadFilaSala;
    }

    public static class Builder {
        private int idSala;
        private String nombreSala;
        private int capacidadColumnaSala;
        private int capacidadFilaSala;

        public Builder idSala(int idSala) {
            this.idSala = idSala;
            return this;
        }

        public Builder nombreSala(String nombreSala) {
            this.nombreSala = nombreSala;
            return this;
        }

        public Builder capacidadColumnaSala(int capacidadColumnaSala) {
            this.capacidadColumnaSala = capacidadColumnaSala;
            return this;
        }

        public Builder capacidadFilaSala(int capacidadFilaSala) {
            this.capacidadFilaSala = capacidadFilaSala;
            return this;
        }

        public Sala build() {
            return new Sala(this);
        }
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala=" + idSala +
                ", nombreSala='" + nombreSala + '\'' +
                ", capacidadColumnaSala=" + capacidadColumnaSala +
                ", capacidadFilaSala=" + capacidadFilaSala +
                '}';
    }
}
