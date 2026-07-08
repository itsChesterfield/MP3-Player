package net.sharksystem.app.componentbasedappskeleton.app.componentView;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

/**
 * Das ist die Schnittstelle für die Komponente View.
 */
public interface View {

    void showLibrary(List<MP3File> list);

    void showCurrentMP3(MP3File file, int currentTime);

    void showDeviceList(List<Device> deviceList);

    void showTransferStatus(Device device, String status);

    void addToLibrary(MP3File mp3);

    void removeFromLibrary(MP3File mp3);

    void updateProgress(int progress);
}
