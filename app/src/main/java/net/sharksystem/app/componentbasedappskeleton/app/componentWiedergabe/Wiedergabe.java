package net.sharksystem.app.componentbasedappskeleton.app.componentWiedergabe;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

/**
 * Das ist die Schnittstelle für die Komponente Wiedergabe.
 */
public interface Wiedergabe {
    boolean play(MP3File file, int startSeconds);

    boolean pause();

    boolean forward(int seconds);

    boolean backward(int seconds);
}
