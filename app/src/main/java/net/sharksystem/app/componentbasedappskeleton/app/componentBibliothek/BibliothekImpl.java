package net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.ArrayList;
import java.util.List;

public class BibliothekImpl implements Bibliothek{
    private List<MP3File> library;

    /**
     * Setter Methode für die Liste library.
     * @param list Liste mit MP3Dateien.
     * @return boolean über den Status.
     */
    @Override
    public boolean createLibrary(List<MP3File> list) {
        if(list == null) return false; //TODO: Muss ich hier noch auf etwas anderes Überprüfen als nur null?
        this.library = list;
        return true;
    }

    /**
     * Getter Methode für die Liste library.
     * @return Liste mit MP3Dateien.
     * @throws NullPointerException wenn die Liste null ist.
     */
    @Override
    public List<MP3File> readLibrary() throws NullPointerException{
        if(library == null){ //TODO: Muss ich hier noch was anderes Überprüfen, als nur null?
            throw new NullPointerException("Liste mit null kann nicht gelesen werden");
        }

        return new ArrayList<>(this.library);
    }

    /**
     * Fügt mp3 in die Liste ein.
     * @param mp3 gewünschte MP3 die hinzugefügt werden soll.
     * @return boolean über den Status.
     */
    @Override
    public boolean addFile(MP3File mp3) {
        if(mp3 == null) return false; //TODO: Muss ich die MP3 noch auf etwas anderes überprüfen?
        if(library.contains(mp3)) return false;
        library.add(mp3);
        return true;
    }

    /**
     * Fügt mp3 in die Liste ein.
     * @param mp3 gewünschte MP3 die gelöscht werden soll
     * @return boolean über den Status.
     */
    @Override
    public boolean removeFile(MP3File mp3) {
        if(mp3 == null) return false;//TODO: Muss ich die MP3 noch auf etwas anderes überprüfen?
        return library.remove(mp3);
    }
}
