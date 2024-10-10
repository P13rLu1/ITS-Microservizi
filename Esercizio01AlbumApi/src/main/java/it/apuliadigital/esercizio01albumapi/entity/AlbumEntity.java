package it.apuliadigital.esercizio01albumapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Album")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlbum;

    private String title;

    private String author;
}
