package net.sharksystem.app.componentbasedappskeleton.app.componentView;

import android.bluetooth.BluetoothDevice;

import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

/**
 * Das ist die Schnittstelle für die Komponente View.
 */
public interface View {

    void showLibrary(List<MP3File> list);

    void showCurrentMP3(MP3File file, int currentTime);

    void showDeviceList(List<BluetoothDevice> device);

    void showTransferStatus(String status);
}
