package net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

/**
 * Das ist die Schnittstelle für die Komponente Bibliothek.
 */
public interface Bibliothek {

    /**
     * Erstellt eine Bibliothek
     * @param list Ist eine Übergebene Liste, die nur MP3File Formate entgegen nimmt.
     * @return boolean, ob die Klasse erstellt worden ist oder nicht.
     */
    boolean createLibrary(List<MP3File> list);

    /**
     * Liest eine Bibliothek aus.
     * @return eine Liste, nur mit MP3File's
     */
    List<MP3File> readLibrary();

    /**
     * Fügt eine MP3File in die Liste ein.
     * @param mp3 gewünschte MP3 die hinzugefügt werden soll.
     * @return boolean ob eine MP3 Hinzugefügt wurde.
     */
    boolean addFile(MP3File mp3);

    /**
     * Löscht eine MP3File aus der Liste.
     * @param mp3 gewünschte MP3 die gelöscht werden soll
     * @return boolean ob eine MP3 Hinzugefügt wurde.
     */
    boolean removeFile(MP3File mp3);

}
