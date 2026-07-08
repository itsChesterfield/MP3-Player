package net.sharksystem.app.componentbasedappskeleton;

import net.sharksystem.app.componentbasedappskeleton.app.Controller;
import net.sharksystem.app.componentbasedappskeleton.app.componentView.View;
import net.sharksystem.app.componentbasedappskeleton.app.componentBibliothek.Bibliothek;
import net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt.Fortschritt;
import net.sharksystem.app.componentbasedappskeleton.app.componentScanner.Scanner;
import net.sharksystem.app.componentbasedappskeleton.app.componentTransfer.Transfer;
import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.Wiedergabe;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Test;
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

    @Test
    public void appStartZeigtBibliothek(){
        MP3File mp3 = new MP3File("Test", "tetst");
        List<MP3File> listi = new ArrayList<>();
        listi.add(mp3);
        Mockito.when(bib.readLibrary()).thenReturn(listi);
        controller.onAppStart();
        Mockito.verify(view).showLibrary(listi);
    }
}
