package bridge.factory;

import bridge.Device;
import bridge.Radio;
import bridge.Tv;

public class DeviceFactory {

    public static Device getDevice(String type){
        if(type.equalsIgnoreCase("tv")){
            return new Tv("samsung");
        }else if (type.equalsIgnoreCase("radio")){
            return new Radio("pioner");
        }else {
            throw new RuntimeException("Device not found");
        }
    }
}
