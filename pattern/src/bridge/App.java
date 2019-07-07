package bridge;

import bridge.factory.DeviceFactory;

public class App {


    public static void main(String[] args) {
        Device device = DeviceFactory.getDevice("tv");
        Remote remote = new ControlDesk(device);

        remote.power();
        remote.info();
        remote.plusVolume();
        remote.info();

    }





}
