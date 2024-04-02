package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import javax.validation.OverridesAttribute;
import javax.validation.OverridesAttribute.List;

import com.example.song.model.SongRowMapper;
import com.example.song.model.Song;
import com.example.song.repository.SongRepository;

@Service
public class SongH2Service implements SongRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> songList = db.query("SELECT * FROM playlist", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(songList);

        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        try {
            Song song = db.queryForObject("SELECT * FROM playlist WHERE id = ?", new SongRowMapper(), songId);
            return song;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}