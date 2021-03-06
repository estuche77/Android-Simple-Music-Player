package cr.ac.itcr.jlatouche.simplemusicplayer;

import java.io.Serializable;

/**
 * Created by estuche on 17/03/18.
 */

public class Song {
    String name;
    String author;
    String lyrics;
    int time;
    int coverArt;

    public Song() {
        this.name = "";
        this.author = "";
        this.lyrics = "";
    }

    public Song(String name, String author, String lyrics, int time) {
        this.name = name;
        this.author = author;
        this.lyrics = lyrics;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(int coverArt) {
        this.coverArt = coverArt;
    }
}
