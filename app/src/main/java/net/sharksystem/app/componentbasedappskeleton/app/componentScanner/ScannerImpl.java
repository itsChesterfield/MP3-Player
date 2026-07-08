package net.sharksystem.app.componentbasedappskeleton.app.componentScanner;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScannerImpl implements Scanner{
    private String verzeichnis;
    public ScannerImpl(String verzeichnis){
        this.verzeichnis = verzeichnis;
    }
    @Override
    public List<MP3File> scanForFiles(){
        File file = new File(verzeichnis);
        File[] files = file.listFiles();
        if(files == null){
            return Collections.emptyList();
        }
        List<MP3File> mp3Files = new ArrayList<>();
        for(File f : files){
           if(f.getName().endsWith(".mp3")){
               mp3Files.add(new MP3File(f.getName(), f.getAbsolutePath()));
           }
        }
        return mp3Files;
    }
}
