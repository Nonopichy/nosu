package com.nonopichy.nosu;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

public class FramePlayer {

    /*
    private X11.Display disp;
    private JFXPanel jfxPanel;
    private int w, h;

    public FramePlayer(X11.Display disp, int w, int h, boolean autoInit) {
        this.disp = disp;
        this.w = w;
        this.h = h;
        if(autoInit) this.init();
    }

    public void init() {
        this.jfxPanel = new JFXPanel();

        Dimension dim = new Dimension(w, h);
        this.jfxPanel.setPreferredSize(dim);
        this.jfxPanel.setBackground(new Color(0, 0, 0, 255));
        this.jfxPanel.setOpaque(false);

        this.disp.getFrame().add(this.jfxPanel, 1);
    }


    public void addVideo(File video1) {
        Util.initJavaFX();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Code to change Swing data.

                File video = new File("C:\\Users\\980001005\\Videos\\IMG_6503.mp4");
                String url = null;

                try {
                    url = video.toURI().toURL().toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                Media media = new Media(url);
                javafx.scene.media.MediaPlayer player = new javafx.scene.media.MediaPlayer(media);
                MediaView view = new MediaView(player);

                Group g = new Group(view);
                Scene s = new Scene(g);
                s.setFill(Paint.valueOf("TRANSPARENT")); // THIS MAKES IT TRANSPARENT!

                player.play();
                jfxPanel.setScene(s);
            }
        });
    }

    public void renderVideo() {
        this.jfxPanel.paint(this.disp.getGfx().get());
    }

    public void renderVideo(KCGraphics gfx) {
        this.jfxPanel.paint(gfx.get());
    }

     */

}
