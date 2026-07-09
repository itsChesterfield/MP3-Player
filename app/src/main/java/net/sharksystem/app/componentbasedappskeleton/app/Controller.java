package net.sharksystem.app.componentbasedappskeleton.app;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.ReceiveCallback;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.Transfer;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.Wiedergabe;
import net.sharksystem.app.componentbasedappskeleton.app.componentView.View;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Bibliothek bibliothek;
    Scanner scanner;
    Fortschritt fortschritt;
    Transfer transfer;
    View view;
    Wiedergabe wiedergabe;
    MP3File mp3;
    int currentTime;
    int tickSpeicher = 0;

    /**
     * Konstruktor für den Controller.
     * @param bibliothek
     * @param scanner
     * @param fortschritt
     * @param transfer
     * @param view
     * @param wiedergabe
     */
    public Controller(Bibliothek bibliothek, Scanner scanner, Fortschritt fortschritt, Transfer transfer, View view, Wiedergabe wiedergabe){
        this.bibliothek = bibliothek;
        this.scanner = scanner;
        this.fortschritt = fortschritt;
        this.transfer = transfer;
        this.view = view;
        this.wiedergabe = wiedergabe;
    }
    /**
     * Methode die beim Start der App ausgeführt wird.
     * Sie liest die aktuelle Bibliothek und sendet das Ergebnis an die View.
     */
    public void onAppStart(){
        view.showLibrary(bibliothek.readLibrary());
    }

    /**
     * Vergleicht die aktuelle Liste mit der neuen Liste an MP3's die der Scan gefunden hat.
     */
    public void syncBibliothek(){
        List<MP3File> liste = scanner.scanForFiles();
        List<MP3File> bib = bibliothek.readLibrary();

        for (MP3File file : liste) {
            if (!bib.contains(file)){
                bibliothek.addFile(file);
                view.addToLibrary(file);
                }
            }

        for(MP3File file : bib){
            if(!liste.contains(file)){
                bibliothek.removeFile(file);
                view.removeFromLibrary(file);
                }
            }
        }

    /**
     * Sobald man auf eine mp3 klickt, wird die Methode ausgelöst.
     * Sie legt die aktuelle MP3 fest, in der Zwischenablage. Holt sich den aktuellen Fortschritt von der Datei die gespeichert wurde
     * und zeigt die MP3 und die aktuelle Zeit auf dem Display an.
     * Ah und startet sie btw.
     * @param mp3 übernimmt die gewünschte bzw. angeklickte mp3.
     */
    public void onDateiAusgewaehlt(MP3File mp3){
        this.mp3 = mp3;
        this.currentTime = fortschritt.readCurrentTime(mp3);
        wiedergabe.play(mp3, currentTime);
        view.showCurrentMP3(mp3, currentTime);
    }

    /**
     * onTick ist eine Methode welche die aktuelle Zeit updatet, sowohl im Zwischenspeicher als auch aufm Display (Jede Sekunde).
     * onTick sorgt auch dafür, das alle 15 ticks die Zeit in Fortschritt gespeichert wird.
     */
    public void onTick() {
        currentTime++;
        view.updateProgress(currentTime);
        tickSpeicher++;
        if(tickSpeicher == 15) {
            fortschritt.updateTime(mp3, currentTime);
            tickSpeicher = 0;
        }
    }

    /**
     * onPause speichert die aktuelle Zeit und pausiert dann die Audio.
     */
    public void onPause(){
        fortschritt.updateTime(mp3, currentTime);
        wiedergabe.pause();
    }

    /**
     * Noch kein Kommentar.
     */
    public void onEmpfangAktivieren(){ //TODO: Das ist eine schwierige Stelle die ich noch nicht verstehe.
        transfer.enableReceiving(new ReceiveCallback() {
            @Override
            public void onFileReceived(MP3File mp3) {
                bibliothek.addFile(mp3);
                view.addToLibrary(mp3);
            }
        });
    }

    /**
     * Diese Methode speichert den Fortschritt, schließt die Wiedergabe und gibt die aktuelle Bibliothek wieder.
     */
    public void onPlayerSchliessen(){
        fortschritt.updateTime(mp3, currentTime);
        wiedergabe.pause();
        view.showLibrary(bibliothek.readLibrary());
    }


    /**
     * if(liste.contains(file) = true && bib.contains(file) = false){bibliothek.add(file);}
     * if(liste.contains(file) = false && bib.contains(file) = true){bibliothek.remove(file);}
     */
}
