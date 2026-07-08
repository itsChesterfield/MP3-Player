package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

/**
 * Interface welches genutzt wird, wenn ein MP3 erhalten wurde.
 */
public interface ReceiveCallback {
    void onFileReceived(MP3File mp3);
}
