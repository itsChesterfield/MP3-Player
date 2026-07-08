package net.sharksystem.app.componentbasedappskeleton.app;

import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.Transfer;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.Wiedergabe;
import net.sharksystem.app.componentbasedappskeleton.app.componentView.View;

public class Controller {
    Bibliothek bibliothek;
    Scanner scanner;
    Fortschritt fortschritt;
    Transfer transfer;
    View view;
    Wiedergabe wiedergabe;

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
     */
    public void onAppStart(){

    }

}
