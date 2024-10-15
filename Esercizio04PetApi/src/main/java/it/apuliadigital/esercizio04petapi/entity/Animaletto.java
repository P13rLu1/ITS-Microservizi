package it.apuliadigital.esercizio04petapi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Animaletto")
public class Animaletto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tag")
    private String tag;

    public Animaletto() {
    }

    public Animaletto(Long id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animaletto that = (Animaletto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tag);
    }

    @Override
    public String toString() {
        return "Animaletto{" + "id=" + id + ", name='" + name + '\'' + ", tag='" + tag + '\'' + '}';
    }
}
