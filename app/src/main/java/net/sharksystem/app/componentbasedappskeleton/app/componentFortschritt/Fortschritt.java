package net.sharksystem.app.componentbasedappskeleton.app.componentFortschritt;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

/**
 * Das ist die Schnittstelle für die Komponente Fortschritt.
 */
public interface Fortschritt {

    boolean updateTime(MP3File file, int seconds);

    int readCurrentTime(MP3File file);
}
