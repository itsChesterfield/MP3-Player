package net.sharksystem.app.componentbasedappskeleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.sharksystem.app.componentbasedappskeleton.app.Controller;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.BibliothekImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.FortschrittImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.ScannerImpl;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.ReceiveCallback;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.Transfer;
import net.sharksystem.app.componentbasedappskeleton.app.componentView.View;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.Wiedergabe;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.WiedergabeImpl;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;
import android.media.MediaPlayer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class IntegrationsTest {
    Bibliothek bib = new BibliothekImpl();
    Scanner scanner = new ScannerImpl("C:\\Users\\Arbeit\\MP3-Player\\app\\src\\test\\java\\net\\sharksystem\\app\\componentbasedappskeleton\\MusikTestOrdner\\mehrereFile");
    Fortschritt fortschritt = new FortschrittImpl();
    Transfer transfer = Mockito.mock(Transfer.class);
    View view = Mockito.mock(View.class);
    Wiedergabe wiedergabe = new WiedergabeImpl(Mockito.mock(MediaPlayer.class));
    Controller controller = new Controller(bib, scanner, fortschritt, transfer, view, wiedergabe);
    List<MP3File> listi;
    MP3File mp3;

    @Before
    public void setup() {
        mp3 = new MP3File("Test", "tetst");
        bib.createLibrary(new ArrayList<>());
        bib.addFile(mp3);
        listi = new ArrayList<>();
        listi.add(mp3);
    }

    @Test
    public void cache() {
        controller.onAppStart();
        Mockito.verify(view).showLibrary(bib.readLibrary());
    }
    @Test
    public void wiedergabeFortschritt(){
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i <= 15; i++) controller.onTick();
        assertEquals(15, fortschritt.readCurrentTime(mp3));
    }
    @Test
    public void wiedergabeFortschrittView(){
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i <= 3; i++) controller.onTick();
        Mockito.verify(view, Mockito.times(3)).updateProgress(Mockito.anyInt());
    }
    @Test
    public void transferBibliothek(){
        controller.onEmpfangAktivieren();
        ArgumentCaptor<ReceiveCallback> captor = ArgumentCaptor.forClass(ReceiveCallback.class);
        Mockito.verify(transfer).enableReceiving(captor.capture());
        captor.getValue().onFileReceived(mp3);
        assertTrue(bib.readLibrary().contains(mp3));
        Mockito.verify(view).addToLibrary(mp3);
    }
}
