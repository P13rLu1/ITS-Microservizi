package it.apuliadigital.esercizio05anagraficaclient.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAnagrafica")
    private Long idAnagrafica;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "numeritelefonici")
    private String numeriTelefonici;

    @Column(name = "elencoIndirizziEmail")
    private List<String> elencoIndirizziEmail = new ArrayList<>();

    @Column(name = "dataNascita")
    private String dataNascita;

    public PersonaEntity() {
    }

    public PersonaEntity(Long idAnagrafica, String nome, String cognome, String numeriTelefonici, List<String> elencoIndirizziEmail, String dataNascita) {
        this.idAnagrafica = idAnagrafica;
        this.nome = nome;
        this.cognome = cognome;
        this.numeriTelefonici = numeriTelefonici;
        this.elencoIndirizziEmail = elencoIndirizziEmail;
        this.dataNascita = dataNascita;
    }

    public Long getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(Long idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeriTelefonici() {
        return numeriTelefonici;
    }

    public void setNumeriTelefonici(String numeriTelefonici) {
        this.numeriTelefonici = numeriTelefonici;
    }

    public @Valid List<String> getElencoIndirizziEmail() {
        return elencoIndirizziEmail;
    }

    public void setElencoIndirizziEmail(@Valid List<String> elencoIndirizziEmail) {
        this.elencoIndirizziEmail = elencoIndirizziEmail;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaEntity that = (PersonaEntity) o;
        return Objects.equals(idAnagrafica, that.idAnagrafica) && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(numeriTelefonici, that.numeriTelefonici) && Objects.equals(elencoIndirizziEmail, that.elencoIndirizziEmail) && Objects.equals(dataNascita, that.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnagrafica, nome, cognome, numeriTelefonici, elencoIndirizziEmail, dataNascita);
    }

    @Override
    public String toString() {
        return "PersonaEntity{" +
                "idAnagrafica=" + idAnagrafica +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numeriTelefonici='" + numeriTelefonici + '\'' +
                ", elencoIndirizziEmail=" + elencoIndirizziEmail +
                ", dataNascita='" + dataNascita + '\'' +
                '}';
    }
}
