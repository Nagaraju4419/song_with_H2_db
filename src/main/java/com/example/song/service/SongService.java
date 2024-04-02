package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.SongRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

public class SongService implements SongRepository {
    private HashMap<Integer, Song> hmap = new HashMap<>();
    int uniqueId = 3;

    public SongService() {
        Song s1 = new Song(1, "Nagaraju", "Nagaraju", "Nagaraju", "Nagaraju");
        hmap.put(s1.getId(), s1);
    }

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songCollection = hmap.values();
        ArrayList<Song> songs = new ArrayList<>(songCollection);
        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        Song song = hmap.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }
}