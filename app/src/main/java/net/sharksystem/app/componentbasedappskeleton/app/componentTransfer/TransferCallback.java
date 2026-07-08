package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;

/**
 * Interface welches sich um die Dateiübertragung kümmert.
 */
public interface TransferCallback {
    void onProgress(Device device, int prozent);
    void onSuccess(Device device);
    void onFailure(Device device, String fehler);
}
