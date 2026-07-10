package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.ArrayList;

public class BibliothekUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliothek); // Setzt das Layout für die Bibliothek.
        RecyclerView rec = findViewById(R.id.recyclerView);
        rec.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MP3File> liste = new ArrayList<>();
            for(int i  = 0; i < 5; i++){
                MP3File mp3 = new MP3File("String ja ", "dowaindoamdw");
                liste.add(mp3);
            }
            MP3Adapter adapter = new MP3Adapter(liste);
            rec.setAdapter(adapter);
    }
}
