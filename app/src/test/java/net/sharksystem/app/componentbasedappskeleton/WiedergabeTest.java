package net.sharksystem.app.componentbasedappskeleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.media.MediaPlayer;

import net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe.WiedergabeImpl;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Testklasse für die Klasse Test. Wir überprüfen hier ob die Methoden in Wiedergabe richtig funktionieren.
 */
public class WiedergabeTest {
    MediaPlayer player = Mockito.mock(MediaPlayer.class);
    WiedergabeImpl wiedergabeObjekt = new WiedergabeImpl(player);
    MP3File littleMP3 = new MP3File("meinErsterSongIGuess", "src/test/java/net/sharksystem/app/componentbasedappskeleton/MusikTestOrdner/einFile/einTest");


    /**
     * Testet ob wir bei play() starten?
     */
    @Test
    public void playTest(){
    assertTrue(wiedergabeObjekt.play(littleMP3, 0));
    }
    /**
     * Test der überpüft ob wir vorspulen können.
     */
    @Test
    public void forward(){
        wiedergabeObjekt.play(littleMP3, 100);
        wiedergabeObjekt.forward(30);
        assertEquals(130, wiedergabeObjekt.getCurrentTime());
    }
    /**
     * Testet ob wir zurückspulen können.
     */
    @Test
    public void backward(){
        wiedergabeObjekt.play(littleMP3, 100);
        wiedergabeObjekt.backward(30);
        assertEquals(70, wiedergabeObjekt.getCurrentTime());
    }

    /**
     * Test ob wir pausieren können.
     */
    @Test
    public void pause(){
        wiedergabeObjekt.play(littleMP3, 0);
        assertTrue(wiedergabeObjekt.pause());
    }
    /**
     * Testet ob wir mit null play machen können.
     */
    @Test
    public void playMitNull(){
        assertFalse(wiedergabeObjekt.play(null, 0));
    }
}
