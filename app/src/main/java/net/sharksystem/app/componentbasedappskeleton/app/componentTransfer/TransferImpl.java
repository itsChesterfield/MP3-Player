package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;
import net.sharksystem.app.componentbasedappskeleton.app.model.MP3File;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import androidx.annotation.RequiresPermission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransferImpl implements Transfer{
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    BluetoothAdapter bluetooth;
    private Thread receivingThread;
    private boolean isReceiving = false;
    public TransferImpl(BluetoothAdapter bluetooth){
        this.bluetooth = bluetooth;
    }

    /**
     * Sucht die Bluetooth geräte in der Gegend.
     * @param callback
     */
    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    @Override
    public void discoverDevices(DiscoveryCallback callback) {
        if(bluetooth == null){
            callback.onDiscoveryFailed("Bluetooth nicht verfügbar");
            return;
        }
        List<Device> devices = new ArrayList<>();
        for(BluetoothDevice device: bluetooth.getBondedDevices()){
            Device device1 = new Device(device.getName(), device.getAddress());
            devices.add(device1);
        };
        callback.onDevicesFound(devices);
    }

    /**
     * Schickt Dateien über Bluetooth.
     * @param mp3
     * @param deviceList
     * @param transferCallback
     */
    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    @Override
    public void sendFile(MP3File mp3, List<Device> deviceList, TransferCallback transferCallback) {
        for (Device device : deviceList) {
            BluetoothDevice bt = bluetooth.getRemoteDevice(device.getId());
            BluetoothSocket socket = null;
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                socket = bt.createRfcommSocketToServiceRecord(MY_UUID);
                socket.connect();
                fis = new FileInputStream(mp3.getDateiPfad());
                os = socket.getOutputStream();

                File file = new File(mp3.getDateiPfad());
                long totalBytes = file.length();
                long gesendetBytes = 0;

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                    gesendetBytes += bytesRead;
                    int prozent = (int)(gesendetBytes * 100 / totalBytes);
                    transferCallback.onProgress(device, prozent);
                }
                transferCallback.onSuccess(device);
            } catch (IOException e) {
                transferCallback.onFailure(device, e.getMessage());
            } finally {
                try {
                    if (fis != null) fis.close();
                    if (os != null) os.close();
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    // Ignorieren beim Schließen
                }
            }
        }
    }

    /**
     * Aktiviert die Empfangsfunktion.
     * @param callback
     */
    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    @Override
    public void enableReceiving(ReceiveCallback callback) {
        if (bluetooth == null) return;

        receivingThread = new Thread(() -> {
            BluetoothServerSocket serverSocket = null;
            try {
                serverSocket = bluetooth.listenUsingRfcommWithServiceRecord("MP3Transfer", MY_UUID);
                while (isReceiving) {
                    BluetoothSocket socket = null;
                    FileOutputStream fos = null;
                    InputStream is = null;
                    try {
                        socket = serverSocket.accept();
                        is = socket.getInputStream();

                        File tempFile = File.createTempFile("received_", ".mp3");
                        fos = new FileOutputStream(tempFile);

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }

                        MP3File mp3 = new MP3File(tempFile.getName(), tempFile.getAbsolutePath());
                        callback.onFileReceived(mp3);
                    } catch (IOException e) {
                        // Einzelne Übertragung fehlgeschlagen, weiter warten
                    } finally {
                        try {
                            if (fos != null) fos.close();
                            if (is != null) is.close();
                            if (socket != null) socket.close();
                        } catch (IOException e) {
                            // Ignorieren beim Schließen
                        }
                    }
                }
            } catch (IOException e) {
                // ServerSocket konnte nicht geöffnet werden
            } finally {
                try {
                    if (serverSocket != null) serverSocket.close();
                } catch (IOException e) {
                    // Ignorieren beim Schließen
                }
            }
        });

        isReceiving = true;
        receivingThread.start();
    }

    /**
     * Deaktiviert die Empfangsfunktion.
     */
    @Override
    public void disableReceiving() {
        isReceiving = false;
        if (receivingThread != null) {
            receivingThread.interrupt();
            receivingThread = null;
        }
    }

}
