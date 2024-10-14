package it.apuliadigital.esercizio01albumapi.entity;

import java.util.Objects;

public class Contatto {

    private String tipoContatto;
    private String contatto;

    public Contatto() {
    }

    public Contatto(String tipoContatto, String contatto) {
        this.tipoContatto = tipoContatto;
        this.contatto = contatto;
    }

    public String getTipoContatto() {
        return tipoContatto;
    }

    public void setTipoContatto(String tipoContatto) {
        this.tipoContatto = tipoContatto;
    }

    public String getContatto() {
        return contatto;
    }

    public void setContatto(String contatto) {
        this.contatto = contatto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contatto contatto1 = (Contatto) o;
        return Objects.equals(tipoContatto, contatto1.tipoContatto) && Objects.equals(contatto, contatto1.contatto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoContatto, contatto);
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "tipoContatto='" + tipoContatto + '\'' +
                ", contatto='" + contatto + '\'' +
                '}';
    }
}
