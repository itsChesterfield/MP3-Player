package net.sharksystem.app.componentbasedappskeleton;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import org.junit.Test;
import org.junit.Before;

public class MP3FileTest {
    MP3File mp3;
@Before
    public void objektErstellen(){
        mp3 = new MP3File("Hallo", "MaxD");
    }

    @Test
    public void testGetters() {
        System.out.println(mp3.getName());
        System.out.println(mp3.getDateiPfad());
    }
}
