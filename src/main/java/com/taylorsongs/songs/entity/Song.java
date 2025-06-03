package com.taylorsongs.songs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String album;

    @NotNull
    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    @NotNull
    
    private Genre genre;

    public Song() {}

    public Song(String title, String album, Integer releaseYear, Genre genre) {
        this.title = title;
        this.album = album;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    // Getters y setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAlbum() { return album; }

    public void setAlbum(String album) { this.album = album; }

    public Integer getReleaseYear() { return releaseYear; }

    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public Genre getGenre() { return genre; }

    public void setGenre(Genre genre) { this.genre = genre; }
}
