package net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

public class WiedergabeImpl implements Wiedergabe{
    int startSeconds; //TODO: Später löschen
    MP3File mp3;
    @Override
    public boolean play(MP3File mp3, int startSeconds) {
        if(mp3 == null) return false;
        this.startSeconds = startSeconds; //TODO: Später löschen
        this.mp3 = mp3;
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
