package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import android.bluetooth.BluetoothDevice;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;
import java.util.List;

/**
 * Das ist die Schnittstelle für die Komponente Bibliothek.
 */
public interface Transfer {

    List<BluetoothDevice> discoverDevice();

    void sendFile(MP3File file, BluetoothDevice device);

    void enableReceiving();

    MP3File recieveFile();
}
