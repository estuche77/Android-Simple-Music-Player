package cr.ac.itcr.jlatouche.simplemusicplayer;

/**
 * Created by estuche on 17/03/18.
 */

public class Song {
    String name;
    String author;
    String lyrics;
    int coverArt;

    public Song() {
        this.name = "";
        this.author = "";
        this.lyrics = "";
    }

    public Song(String name, String author, String lyrics) {
        this.name = name;
        this.author = author;
        this.lyrics = lyrics;
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
}
