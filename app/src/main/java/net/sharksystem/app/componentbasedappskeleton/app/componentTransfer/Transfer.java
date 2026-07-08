package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;
import java.util.List;

/**
 * Interface für den Austausch von MP3Files.
 */
public interface Transfer {
    void discoverDevices(DiscoveryCallback callback);
    void sendFile(MP3File mp3, List<Device> deviceList, TransferCallback transferCallback);
    void enableReceiving(ReceiveCallback callback);
    void disableReceiving();
}
