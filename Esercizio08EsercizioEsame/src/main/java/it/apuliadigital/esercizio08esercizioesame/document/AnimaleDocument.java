package it.apuliadigital.esercizio08esercizioesame.document;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "animale")
public class AnimaleDocument {

    @Id
    private Long idAnimale;
    private String nome;
    private String specie;

    public AnimaleDocument() {
    }

    public AnimaleDocument(Long idAnimale, String nome, String specie) {
        this.idAnimale = idAnimale;
        this.nome = nome;
        this.specie = specie;
    }

    public Long getIdAnimale() {
        return idAnimale;
    }

    public void setIdAnimale(Long idAnimale) {
        this.idAnimale = idAnimale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimaleDocument that = (AnimaleDocument) o;
        return Objects.equals(idAnimale, that.idAnimale) && Objects.equals(nome, that.nome) && Objects.equals(specie, that.specie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimale, nome, specie);
    }

    @Override
    public String toString() {
        return "AnimaleDocument{" +
                "idAnimale='" + idAnimale + '\'' +
                ", nome='" + nome + '\'' +
                ", specie='" + specie + '\'' +
                '}';
    }
}
