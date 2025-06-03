package com.taylorsongs.songs.repository;

import com.taylorsongs.songs.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongsRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitleAndAlbum(String title, String album);
}
