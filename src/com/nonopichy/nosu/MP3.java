package com.nonopichy.nosu;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MP3 {
    private String filename;
    private Player player;
    private AudioDevice audio;

    // constructor that takes the name of an MP3 file
    public MP3(String filename) {

        this.filename = filename;
    }

    public void close() {
        if (player != null) player.close();
    }

    // play the MP3 file to the sound card
    public void play() {
        try {

           FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
/*
            FactoryRegistry r = FactoryRegistry.systemRegistry();
            AudioDevice audio = r.createAudioDevice();

 */
            player = new Player(bis);


        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();

    }
}