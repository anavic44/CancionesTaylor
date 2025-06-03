package com.taylorsongs.songs.exception;

public class SongDoesntExistException extends RuntimeException {
    public SongDoesntExistException() {
        super();
    }

    public SongDoesntExistException(String message) {
        super(message);
    }
}
