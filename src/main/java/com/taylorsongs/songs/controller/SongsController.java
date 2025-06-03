package com.taylorsongs.songs.controller;

import com.taylorsongs.songs.entity.Song;
import com.taylorsongs.songs.service.SongsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongsService songsService;

    @GetMapping
    public ResponseEntity<List<Song>> findAll() {
        return new ResponseEntity<>(songsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        Optional<Song> song = songsService.findById(id);
        return song.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Song> create(@RequestBody @Valid Song song) {
        return new ResponseEntity<>(songsService.create(song), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        songsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
