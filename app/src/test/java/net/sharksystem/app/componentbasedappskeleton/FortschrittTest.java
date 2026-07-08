package net.sharksystem.app.componentbasedappskeleton;
import static org.junit.Assert.assertEquals;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.BibliothekImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.FortschrittImpl;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FortschrittTest {
    MP3File testi = new MP3File("Test", "Test");
    FortschrittImpl test = new FortschrittImpl();

    /**
     * Testet ob die Zeitspanne richtig gespeichert wird.
     */
    @Test
    public void zeitspanneUndLesen(){
        test.updateTime(testi, 200);
        assertEquals(200, test.readCurrentTime(testi));
    }

    /**
     * Ob der Standard Wert richtig gesetzt wird.
     */
    @Test
    public void standardwertOhneEintrag(){
        assertEquals(0, test.readCurrentTime(testi));
    }

    /**
     * Ob für die einzelnen Dateien die Zeitspanne gespeichert wird.
     */
    @Test
    public void mehrereDateien(){
        MP3File dateiA = new MP3File("TitelA", "pfad/a.mp3");
        MP3File dateiB = new MP3File("TitelB", "pfad/b.mp3");

        FortschrittImpl fortschritt = new FortschrittImpl();
        fortschritt.updateTime(dateiA, 30);
        fortschritt.updateTime(dateiB, 90);

        assertEquals(30, fortschritt.readCurrentTime(dateiA));
        assertEquals(90, fortschritt.readCurrentTime(dateiB));
    }
}
