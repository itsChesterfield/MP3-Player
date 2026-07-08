package net.sharksystem.app.componentbasedappskeleton.app.componentScanner;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

/**
 * Das ist die Schnittstelle für die Komponente Scanner.
 */
public interface Scanner {

    List<MP3File> scanForFiles();
}
