package org.example;

// Java Program to Illustrate Creation of Simple POJO Class

// Importing required classes
import javax.persistence.*;

@Entity
@Table(name = "song")
// POJO class
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "songId")
    private int id;

    //@Column(name = "songName")
    private String songName;
    // @Column(name = "singer")
    private String artist;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getSongName() { return songName; }

    public void setSongName(String songName)
    {
        this.songName = songName;
    }

    public String getArtist() { return artist; }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }
}