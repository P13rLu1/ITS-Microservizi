package it.apuliadigital.buttazzoesame1810.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "esame")
public class EsameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "voto")
    private int voto;

    public EsameEntity() {
    }

    public EsameEntity(Long id, String nome, int voto) {
        this.id = id;
        this.nome = nome;
        this.voto = voto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsameEntity that = (EsameEntity) o;
        return voto == that.voto && Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, voto);
    }

    @Override
    public String toString() {
        return "EsameEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", voto=" + voto +
                '}';
    }
}
