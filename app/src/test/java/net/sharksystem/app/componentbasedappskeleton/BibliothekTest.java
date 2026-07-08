package net.sharksystem.app.componentbasedappskeleton;

import static org.junit.Assert.assertEquals;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.BibliothekImpl;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BibliothekTest {

    @Test
    public void leereListe(){
        BibliothekImpl test = new BibliothekImpl();
        test.createLibrary(new ArrayList<MP3File>());
        List<MP3File> list = test.readLibrary();
        assertEquals(0, list.size());
    }
    @Test
    public void listeEinElement(){
        BibliothekImpl test = new BibliothekImpl();
        List<MP3File> liste = new ArrayList<>();
        liste.add(new MP3File("Titel", "Künstler"));
        test.createLibrary(liste);
        List<MP3File> ergebnis = test.readLibrary();
        assertEquals(1, ergebnis.size());
    }
    @Test
    public void großeListe(){
        BibliothekImpl test = new BibliothekImpl();
        List<MP3File> liste = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            liste.add(new MP3File("Titel" + i, "pfad/" + i + ".mp3"));
        }
        test.createLibrary(liste);
        List<MP3File> ergebnis = test.readLibrary();
        assertEquals(100, ergebnis.size());
    }
}
