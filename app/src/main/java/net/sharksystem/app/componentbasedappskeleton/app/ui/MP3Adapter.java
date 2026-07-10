package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

/**
 * Übsersetzt unsere Listeeinträge von MP3 Dateien, in RecyclerViews.
 */
public class MP3Adapter extends RecyclerView.Adapter{
    private List<MP3File> liste; // Liste welche alle unsere MP3Files beinhaltet.

    public MP3Adapter(List<MP3File> files){
        this.liste = files;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // ViewGroup ist ein Container, der andere Views enthalten kann.
        LayoutInflater layout = LayoutInflater.from(parent.getContext()); // Baut aus einem XML Datei ein Java Objekt. (In den Fall aus der ViewGroup.) - getContext holt sich den Inhalt des Contaniners.
        View view = layout.inflate(R.layout.item_mp3, parent, false); // Holt sich das Layout Datei item_mp3, nimmt sich die Regeln für die Darstellung und erzeugt die View. Fügt es aber nicht als Kind in den Container mit ein.
        return new MP3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) { // Wir holen in die die gehaltene MP3 und geben ihr eine Position.
        MP3File mp3 = liste.get(position); // Holt sich die mp3 an der folgenden Position.
        MP3ViewHolder viewHolder = (MP3ViewHolder)holder; // Castet den holder
        viewHolder.textView.setText(mp3.getName()); // Speichert den Namen der mp3 in die TextView.
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    private class MP3ViewHolder extends RecyclerView.ViewHolder{
        TextView textView; // Wir speichern ein TextView Objekt.
        public MP3ViewHolder(@NonNull View itemView) { //TODO: Wofür steht NonNull?
            super(itemView);
            textView = itemView.findViewById(R.id.MP3Button); // Wir speichern die ID von dem Button in die TextView. Damit wir schneller darauf zugreifen können und Java genau weiß, auf welche wir uns beziehen.
        }
    }
}
