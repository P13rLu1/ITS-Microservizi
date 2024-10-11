package it.apuliadigital.esercizio01albumapi.entity;

import it.apuliadigital.esercizio01albumapi.model.Album.GenereEnum;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.*;

@Entity
@Table(name = "Album")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long idAlbum;

    @Column(name = "titolo")
    private String title;

    @Column(name = "autore")
    private String author;

    @Column(name = "anno_pubblicazione")
    private Integer year;

    @Column(name = "data_uscita")
    private String releaseDate;

    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private GenereEnum genre;

    @Column(name = "disponibile")
    private boolean available;

    @Valid
    @Column(name = "tracce")
    private List<String> tracks = new ArrayList<>();

    @Valid
    @Column(name = "band")
    private List<String> band = new ArrayList<>();

    public AlbumEntity() {
    }

    public AlbumEntity(Long idAlbum, String title, String author, Integer year, String releaseDate, GenereEnum genre, boolean available, List<String> tracks, List<String> band) {
        this.idAlbum = idAlbum;
        this.title = title;
        this.author = author;
        this.year = year;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.available = available;
        this.tracks = tracks;
        this.band = band;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public GenereEnum getGenre() {
        return genre;
    }

    public void setGenre(GenereEnum genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public @Valid List<String> getTracks() {
        return tracks;
    }

    public void setTracks(@Valid List<String> tracks) {
        this.tracks = tracks;
    }

    public @Valid List<String> getBand() {
        return band;
    }

    public void setBand(@Valid List<String> band) {
        this.band = band;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity entity = (AlbumEntity) o;
        return available == entity.available && Objects.equals(idAlbum, entity.idAlbum) && Objects.equals(title, entity.title) && Objects.equals(author, entity.author) && Objects.equals(year, entity.year) && Objects.equals(releaseDate, entity.releaseDate) && genre == entity.genre && Objects.equals(tracks, entity.tracks) && Objects.equals(band, entity.band);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlbum, title, author, year, releaseDate, genre, available, tracks, band);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "idAlbum=" + idAlbum +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre=" + genre +
                ", available=" + available +
                ", tracks=" + tracks +
                ", band=" + band +
                '}';
    }
}
