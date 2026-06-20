package net.sharksystem.app.componentbasedappskeleton.app.componentModel;

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
    public static void main(String[] args){
        MP3File mp3 = new MP3File("Test", "Test");
        System.out.println(mp3.getName());
        System.out.println(mp3.getDateiPfad());
    }
}
