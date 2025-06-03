package com.taylorsongs.songs.service;

import com.taylorsongs.songs.entity.Song;
import com.taylorsongs.songs.exception.SongAlreadyExistsException;
import com.taylorsongs.songs.exception.SongDoesntExistException;
import com.taylorsongs.songs.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService {

    @Autowired
    private SongsRepository songsRepository;

    public List<Song> findAll() {
        return songsRepository.findAll();
    }

    public Optional<Song> findById(Long id) {
        return songsRepository.findById(id);
    }

    public Song create(Song song) {
        Optional<Song> existing = songsRepository.findByTitleAndAlbum(song.getTitle(), song.getAlbum());

        if (existing.isPresent()) {
            throw new SongAlreadyExistsException("Song already exists.");
        }

        return songsRepository.save(song);
    }

    public void deleteById(Long id) {
        if (!songsRepository.existsById(id)) {
            throw new SongDoesntExistException("Song not found.");
        }

        songsRepository.deleteById(id);
    }
}
