package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

public class MP3Adapter extends RecyclerView.Adapter{
    private List<MP3File> liste;

    public MP3Adapter(List<MP3File> files){
        this.liste = files;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    private class MP3ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MP3ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.MP3Button);
        }
    }
}
