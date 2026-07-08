package net.sharksystem.app.componentbasedappskeleton.app;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
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
    public void onDateiAusgewaehlt(MP3File mp3){
        this.mp3 = mp3;
        this.currentTime = fortschritt.readCurrentTime(mp3);
        wiedergabe.play(mp3, currentTime);
        view.showCurrentMP3(mp3, currentTime);
    }
    public void onTick(){}
    public void onPause(){}
    public void onEmpfangAktivieren(){}
    public void onPlayerSchliessen(){}


    /**
     * if(liste.contains(file) = true && bib.contains(file) = false){bibliothek.add(file);}
     * if(liste.contains(file) = false && bib.contains(file) = true){bibliothek.remove(file);}
     */
}
