package com.example.song.repository;

import java.util.*;
import com.example.song.model.Song;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongById(int songId);
}