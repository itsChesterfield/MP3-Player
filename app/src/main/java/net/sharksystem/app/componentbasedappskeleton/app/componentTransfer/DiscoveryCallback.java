package net.sharksystem.app.componentbasedappskeleton.app.componentTransfer;

import net.sharksystem.app.componentbasedappskeleton.app.model.Device;

import java.util.List;

/**
 * Die DiscoveryCallback Interface, welches sich um die Geräte suche kümmert.
 */
public interface DiscoveryCallback {
    void onDevicesFound(List<Device> list);
    void onDiscoveryFailed(String fehlerMeldung);
}
