package net.sharksystem.app.componentbasedappskeleton.app.componentModel;

public class mainClass {
    public static void main(String[] args){
        MP3File mp3 = new MP3File("Test", "Test.test.test");
        System.out.println("Name: " + mp3.getName() + "Dateipfad: " + mp3.getDateiPfad());
    }
}
