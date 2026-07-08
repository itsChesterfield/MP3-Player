package net.sharksystem.app.componentbasedappskeleton.app.model;

/**
 * Eine Klasse welche eine MP3 Datie anlegen tut.
 */
public class MP3File {
    /**
     * dateiPfad speichert die angebene Adresse für die Datei.
     */
    private String dateiPfad;
    /**
     * name speichert den Namen unter dem eine Datei gespeichert werden soll.
     */
    private String name;

    public MP3File(String name, String dateiPfad){
        this.dateiPfad = dateiPfad;
        this.name = name;
    }
    /**
     * Getter Methode für Name.
     * @return name um den Namen einer MP3 File zu erfahren.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Getter Methode für dateiPfad.
     * @return name um den dateiPfad einer MP3 File zu erfahren.
     */
    public String getDateiPfad(){
        return this.dateiPfad;
    }

    /**
     * Methode welche Vergleicht ob der angegebene Dateipfad gleich ist.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MP3File mp3File = (MP3File) o;
        return java.util.Objects.equals(dateiPfad, mp3File.dateiPfad);
    }

    /**
     * berechnet den hashCode wo eine mp3 in der HashMap sich befindet.
     * @return
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(dateiPfad);
    }
}
