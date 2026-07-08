package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;
import android.bluetooth.BluetoothAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransferImpl implements Transfer{
    BluetoothAdapter bluetooth;
    public TransferImpl(BluetoothAdapter bluetooth){
        this.bluetooth = bluetooth;
    }

    /**
     * Sucht die Bluetooth geräte in der Gegend.
     * @param callback
     */
    @Override
    public void discoverDevices(DiscoveryCallback callback) {
        List<Device> devices = new ArrayList<>();

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
