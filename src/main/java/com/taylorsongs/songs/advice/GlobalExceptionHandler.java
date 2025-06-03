package com.taylorsongs.songs.advice;

import com.taylorsongs.songs.exception.SongAlreadyExistsException;
import com.taylorsongs.songs.exception.SongDoesntExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SongAlreadyExistsException.class)
    public ResponseEntity<Object> handleSongAlreadyExists(SongAlreadyExistsException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Song already exists.");

        return new ResponseEntity<>(body, HttpStatus.CONFLICT); // 409
    }

    @ExceptionHandler(SongDoesntExistException.class)
    public ResponseEntity<Object> handleSongDoesntExist(SongDoesntExistException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Song not found.");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); // 404
    }
}
