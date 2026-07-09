package net.sharksystem.app.componentbasedappskeleton;

import net.sharksystem.app.componentbasedappskeleton.app.Controller;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.ReceiveCallback;
import net.sharksystem.app.componentbasedappskeleton.app.componentView.View;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.Transfer;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.Wiedergabe;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerTest {
    Bibliothek bib = Mockito.mock(Bibliothek.class);
    Scanner scanner = Mockito.mock(Scanner.class);
    Fortschritt fortschritt = Mockito.mock(Fortschritt.class);
    Transfer transfer = Mockito.mock(Transfer.class);
    View view = Mockito.mock(View.class);
    Wiedergabe wiedergabe = Mockito.mock(Wiedergabe.class);
    Controller controller = new Controller(bib, scanner, fortschritt, transfer, view, wiedergabe);
    List<MP3File> listi;
    MP3File mp3;
    @Before
    public void setup(){
        mp3 = new MP3File("Test", "tetst");
        listi = new ArrayList<>();
        Mockito.when(bib.readLibrary()).thenReturn(listi);
        listi.add(mp3);
    }

    @Test
    public void appStartZeigtBibliothek(){


        controller.onAppStart();
        Mockito.verify(view).showLibrary(listi);
    }

    @Test
    public void scannerFindetNeueDatei(){
        List<MP3File> leereListe = new ArrayList<>();
        Mockito.when(bib.readLibrary()).thenReturn(leereListe); //Aktuelle Bibliothek
        Mockito.when(scanner.scanForFiles()).thenReturn(listi); //Liste an Dateien, die gefunden wird beim scannen, die wir einfügen wollen.
        controller.syncBibliothek();
        Mockito.verify(bib).addFile(mp3);
        Mockito.verify(view).addToLibrary(mp3);
    }

    @Test
    public void removeFromLibrary(){
        List<MP3File> leereListe = new ArrayList<>();
        Mockito.when(bib.readLibrary()).thenReturn(listi); //Aktuelle Bibliothek hat eine Datei
        Mockito.when(scanner.scanForFiles()).thenReturn(leereListe); //Scanner findet nichts mehr
        controller.syncBibliothek();
        Mockito.verify(bib).removeFile(mp3);
        Mockito.verify(view).removeFromLibrary(mp3);
    }

    /**
     * Testet ob die Audio startet, wenn sie im Pause Modus steht.
     */
    @Test
    public void wiedergabeStarten(){
    Mockito.when(fortschritt.readCurrentTime(mp3)).thenReturn(300);
    controller.onDateiAusgewaehlt(mp3);
    Mockito.verify(fortschritt).readCurrentTime(mp3);
    Mockito.verify(wiedergabe).play(mp3, 300);
    Mockito.verify(view).showCurrentMP3(mp3, 300);
    }

    /**
     * Testet ob alle 15 Sekunden der Fortschritt auch gespeichert wird.
     */
    @Test
    public void safeProgress(){ //TODO: Hier könnte der Test theoretisch falsch sein
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i<= 14; i++){
                controller.onTick();
        }
        Mockito.verify(fortschritt, Mockito.never()).updateTime(mp3, 14);
        controller.onTick();
        Mockito.verify(fortschritt).updateTime(mp3, 15);
    }

    /**
     * Testet ob der Fortschritt gespeichert wird, wenn wir die Audio pausieren.
     */
    @Test
    public void breakSafe(){
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i<= 5; i++){
            controller.onTick();
        }
        controller.onPause();
        Mockito.verify(fortschritt).updateTime(mp3, 5);
        Mockito.verify(wiedergabe).pause();
    }

    /**
     * Überprüft ob sich jede Sekunde der Fortschritt aktualisiert.
     */
    @Test
    public void updateTime(){
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i <= 3; i++){
            controller.onTick();
        }
        Mockito.verify(view, Mockito.times(3)).updateProgress(Mockito.anyInt());
    }

    @Test
    public void bluetoothEmpfangen(){ //TODO: Das hier muss ich mir erklären lassen unbedingt mal
        controller.onEmpfangAktivieren();
        ArgumentCaptor<ReceiveCallback> captor = ArgumentCaptor.forClass(ReceiveCallback.class);
        Mockito.verify(transfer).enableReceiving(captor.capture());
        captor.getValue().onFileReceived(mp3);
        Mockito.verify(bib).addFile(mp3);
        Mockito.verify(view).addToLibrary(mp3);
    }

    @Test
    public void playerSchliessen(){
        controller.onDateiAusgewaehlt(mp3);
        for(int i = 1; i <= 3; i++){
            controller.onTick();
        }
        controller.onPlayerSchliessen();
        Mockito.verify(wiedergabe).pause();
        Mockito.verify(fortschritt).updateTime(mp3, 3);
        Mockito.verify(view).showLibrary(listi);
    }
}

