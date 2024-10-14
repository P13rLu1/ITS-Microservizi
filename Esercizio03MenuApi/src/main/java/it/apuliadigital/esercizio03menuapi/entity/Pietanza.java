package it.apuliadigital.esercizio03menuapi.entity;

import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO.TipologiaPiattoEnum;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Pietanza")
public class Pietanza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPietanza")
    private Long idPietanza;

    @Column(name = "nomePietanza")
    private String nomePietanza;

    @Column(name = "fileFoto")
    private String fileFoto;

    @Column(name = "prezzoAlPubblico")
    private Double prezzoAlPubblico;

    @Column(name = "prezzoProduzione")
    private Double prezzoProduzione;

    @Valid
    @Column(name = "ingredienti")
    private List<String> ingredienti = new ArrayList<>();

    @Column(name = "tipologiaPietanza")
    @Enumerated(EnumType.STRING)
    private TipologiaPiattoEnum tipologiaPietanza;

    public Pietanza() {
    }

    public Pietanza(Long idPietanza, String nomePietanza, String fileFoto, Double prezzoAlPubblico, Double prezzoProduzione, List<String> ingredienti, PiattoDTO.TipologiaPiattoEnum tipologiaPietanza) {
        this.idPietanza = idPietanza;
        this.nomePietanza = nomePietanza;
        this.fileFoto = fileFoto;
        this.prezzoAlPubblico = prezzoAlPubblico;
        this.prezzoProduzione = prezzoProduzione;
        this.ingredienti = ingredienti;
        this.tipologiaPietanza = tipologiaPietanza;
    }

    public Long getIdPietanza() {
        return idPietanza;
    }

    public void setIdPietanza(Long idPietanza) {
        this.idPietanza = idPietanza;
    }

    public String getNomePietanza() {
        return nomePietanza;
    }

    public void setNomePietanza(String nomePietanza) {
        this.nomePietanza = nomePietanza;
    }

    public String getFileFoto() {
        return fileFoto;
    }

    public void setFileFoto(String fileFoto) {
        this.fileFoto = fileFoto;
    }

    public Double getPrezzoAlPubblico() {
        return prezzoAlPubblico;
    }

    public void setPrezzoAlPubblico(Double prezzoAlPubblico) {
        this.prezzoAlPubblico = prezzoAlPubblico;
    }

    public Double getPrezzoProduzione() {
        return prezzoProduzione;
    }

    public void setPrezzoProduzione(Double prezzoProduzione) {
        this.prezzoProduzione = prezzoProduzione;
    }

    public @Valid List<String> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(@Valid List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public TipologiaPiattoEnum getTipologiaPietanza() {
        return tipologiaPietanza;
    }

    public void setTipologiaPietanza(TipologiaPiattoEnum tipologiaPietanza) {
        this.tipologiaPietanza = tipologiaPietanza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pietanza pietanza = (Pietanza) o;
        return Objects.equals(idPietanza, pietanza.idPietanza) && Objects.equals(nomePietanza, pietanza.nomePietanza) && Objects.equals(fileFoto, pietanza.fileFoto) && Objects.equals(prezzoAlPubblico, pietanza.prezzoAlPubblico) && Objects.equals(prezzoProduzione, pietanza.prezzoProduzione) && Objects.equals(ingredienti, pietanza.ingredienti) && tipologiaPietanza == pietanza.tipologiaPietanza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPietanza, nomePietanza, fileFoto, prezzoAlPubblico, prezzoProduzione, ingredienti, tipologiaPietanza);
    }

    @Override
    public String toString() {
        return "Pietanza{" +
                "idPietanza=" + idPietanza +
                ", nomePietanza='" + nomePietanza + '\'' +
                ", fileFoto='" + fileFoto + '\'' +
                ", prezzoAlPubblico=" + prezzoAlPubblico +
                ", prezzoProduzione=" + prezzoProduzione +
                ", ingredienti=" + ingredienti +
                ", tipologiaPietanza=" + tipologiaPietanza +
                '}';
    }
}
