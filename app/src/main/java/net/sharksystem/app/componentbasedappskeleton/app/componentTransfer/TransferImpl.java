package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import java.util.List;

public class TransferImpl implements Transfer{
    @Override
    public void discoverDevices(DiscoveryCallback callback) {

    }

    @Override
    public void sendFile(MP3File mp3, List<Device> deviceList, TransferCallback transferCallback) {

    }

    @Override
    public void enableReceiving(ReceiveCallback callback) {

    }

    @Override
    public void disableReceiving() {

    }
}
