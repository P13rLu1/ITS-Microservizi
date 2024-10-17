package it.apuliadigital.esercizio08esercizioesame.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "animale")
public class AnimaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAnimale")
    private Long idAnimale;

    @Column(name = "nome")
    private String nome;

    @Column(name = "specie")
    private String specie;

    public AnimaleEntity() {
    }

    public AnimaleEntity(Long idAnimale, String nome, String specie) {
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
        AnimaleEntity that = (AnimaleEntity) o;
        return Objects.equals(idAnimale, that.idAnimale) && Objects.equals(nome, that.nome) && Objects.equals(specie, that.specie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimale, nome, specie);
    }

    @Override
    public String toString() {
        return "AnimaleEntity{" +
                "idAnimale=" + idAnimale +
                ", nome='" + nome + '\'' +
                ", specie='" + specie + '\'' +
                '}';
    }
}
