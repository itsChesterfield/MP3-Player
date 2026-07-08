package net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.HashMap;

/**
 * Klasse die den Fortschritt einer MP3 Verwaltet.
 */
public class FortschrittImpl implements Fortschritt{
    /**
     * HashMap für eine MP3File und mit welchen Zeitpunkt (Integer) sie beim letzten Mal gespeichert wurde.
     */
    private HashMap<MP3File, Integer> zeitSpeicher = new HashMap<>();
    @Override
    public boolean updateTime(MP3File file, int seconds) {
        if(file == null) return false; //TODO: Muss ich hier noch etwas anderes überprüfen? seconds sollte niemals null sein können?
    zeitSpeicher.put(file, seconds);
    return true;
    }

    @Override
    public int readCurrentTime(MP3File file) {
        if(zeitSpeicher.containsKey(file)) {
            return zeitSpeicher.get(file);
        } else {
            return 0;
        }
    }
}
