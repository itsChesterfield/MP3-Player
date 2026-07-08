package net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe;

import android.media.MediaPlayer;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.io.IOException;

public class WiedergabeImpl implements Wiedergabe{
    int startSeconds; //TODO: Später löschen
    MP3File mp3;
    MediaPlayer player;

    public WiedergabeImpl(MediaPlayer player){
        this.player = player;
    }

    /**
     * Bereitet und startet das abspielen der mp3.
     * @param mp3 aktuelle Datei
     * @param startSeconds bei welcher Zeit der player startet.
     * @return true wenn die Datei gestartet wird, false wenn nicht.
     */
    @Override
    public boolean play(MP3File mp3, int startSeconds) {
        if(mp3 == null) return false;
        this.startSeconds = startSeconds; //TODO: Später löschen
        this.mp3 = mp3;
        try{
            player.reset(); // Sorgt dafür das der Player leer ist, bevor es losgeht.
            player.setDataSource(mp3.getDateiPfad()); // Sucht die Datei am angegebenen Pfad.
            player.prepare(); // Lädt die Datei vor, damit es direkt losgehen kann. Reibungslos.
            player.seekTo(startSeconds * 1000); //Geht an die Startposition (in millisekunden)
            player.start(); //Startet die Datei
        } catch (IOException e) {
            return false;
        }


        return true;
    }

    @Override
    public boolean pause() {
        return true;
    }

    @Override
    public boolean forward(int seconds) {
        this.startSeconds += seconds;
        return true;
    }

    @Override
    public boolean backward(int seconds) {
        this.startSeconds -= seconds;
        return true;
    }
    public int getCurrentTime(){ //TODO: Löschen dient nur der aktuellen Überprüfung.
        return startSeconds;
    }
}
