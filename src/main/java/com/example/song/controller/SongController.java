package com.example.song.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.song.model.Song;
import com.example.song.service.SongH2Service;
import com.example.song.service.SongService;

@RestController
public class SongController {
    @Autowired
    public SongH2Service songService;
    // SongService songService = new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }
    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId){
        return songService.getSongById(songId);
    }
}