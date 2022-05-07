package com.nonopichy.nosu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.Manager;

import javax.media.MediaLocator;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediaPlayer extends JPanel {
    public MediaPlayer(URL mediauUrl) {

        setLayout(new BorderLayout());

        try {


            Player mediaPlayer=Manager.createRealizedPlayer(new MediaLocator(mediauUrl));

            Component video=mediaPlayer.getVisualComponent();

            Component control=mediaPlayer.getControlPanelComponent();

            if (video!=null) {

                add(video, BorderLayout.CENTER);          // place the video component in the panel

            }

            add(control, BorderLayout.SOUTH);            // place the control in  panel

            mediaPlayer.start();

        } catch (Exception e) {

        }

    }
}
