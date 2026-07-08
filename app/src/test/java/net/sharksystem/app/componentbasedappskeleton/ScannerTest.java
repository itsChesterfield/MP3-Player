package net.sharksystem.app.componentbasedappskeleton;
import static org.junit.Assert.assertEquals;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.BibliothekImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.FortschrittImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.ScannerImpl;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class ScannerTest {

    @Test
    public void einFile() {
        ScannerImpl file = new ScannerImpl("src/test/java/net/sharksystem/app/componentbasedappskeleton/MusikTestOrdner/einFile");
        file.scanForFiles();
        assertEquals(1, file.scanForFiles().size());
    }
    @Test
    public void mehrereFiles(){
        ScannerImpl file = new ScannerImpl("src/test/java/net/sharksystem/app/componentbasedappskeleton/MusikTestOrdner/mehrereFile");
        assertEquals(3, file.scanForFiles().size());
    }
    @Test
    public void keinFile(){
        ScannerImpl file = new ScannerImpl("src/test/java/net/sharksystem/app/componentbasedappskeleton/MusikTestOrdner/garKeineFile");
        assertEquals(0, file.scanForFiles().size());
    }
}
