package it.apuliadigital.esercizio02portaleapi.service.impl;

import it.apuliadigital.esercizio02portaleapi.client.album.api.AlbumApi;
import it.apuliadigital.esercizio02portaleapi.client.album.api.SearchApi;
import it.apuliadigital.esercizio02portaleapi.client.album.model.AlbumDTO;
import it.apuliadigital.esercizio02portaleapi.client.artista.api.ArtistApi;
import it.apuliadigital.esercizio02portaleapi.client.artista.model.Artist;
import it.apuliadigital.esercizio02portaleapi.mapper.AlbumMapper;
import it.apuliadigital.esercizio02portaleapi.mapper.ArtistMapper;
import it.apuliadigital.esercizio02portaleapi.model.Album;
import it.apuliadigital.esercizio02portaleapi.model.AlbumEArtista;
import it.apuliadigital.esercizio02portaleapi.model.ArtistaEAlbums;
import it.apuliadigital.esercizio02portaleapi.service.PortaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaleServiceImpl implements PortaleService {

    @Autowired
    private AlbumApi albumApiClient;

    @Autowired
    private ArtistApi artistApiClient;

    @Autowired
    private SearchApi searchApiClient;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public AlbumEArtista albumAndArtist(Long idAlbum) {
        AlbumDTO album = albumApiClient.getAlbum(idAlbum);
        Artist artist = artistApiClient.getArtistById(album.getIdArtist());

        AlbumEArtista albumEArtista = new AlbumEArtista();
        albumEArtista.setAlbum(albumMapper.toAlbum(album));
        albumEArtista.setArtista(artistMapper.toArtist(artist));

        return albumEArtista;
    }

    @Override
    public ArtistaEAlbums artistandAlbum(Long idArtista) {
        Artist artist = artistApiClient.getArtistById(idArtista);
        List<AlbumDTO> albums = searchApiClient.searchAlbums(null, idArtista.toString(), null);

        ArtistaEAlbums artistaEAlbums = new ArtistaEAlbums();
        artistaEAlbums.setArtista(artistMapper.toArtist(artist));
        artistaEAlbums.setListaAlbum(albumMapper.toAlbumList(albums));

        return artistaEAlbums;
    }

    @Override
    public List<Album> getAlbumsByGenre(String genre) {
        List<AlbumDTO> albums = searchApiClient.searchAlbums(null, null, genre);
        return albumMapper.toAlbumList(albums);
    }
}
