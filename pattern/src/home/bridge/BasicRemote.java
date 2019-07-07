package home.bridge;

public class BasicRemote implements Remote {

    protected Device device;

    public BasicRemote(Device device){
        this.device = device;
    }

    @Override
    public void power() {
        if(!device.isEnabled()){
            device.enable();
        }else {device.disable();}
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume()-1);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume()+1);
    }

    @Override
    public void channelDown() {
        device.setChannel(device.getChannel()-1);
    }

    @Override
    public void channelUp() {
        device.setChannel(device.getChannel()+1);
    }
}
