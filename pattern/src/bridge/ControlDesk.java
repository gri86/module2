package bridge;

public class ControlDesk implements Remote {

    private Device device;

    public ControlDesk(Device device){
        this.device = device;
    }


    @Override
    public void power() {
        if(device.isEnabled()){
            device.off();
        }else {
            device.on();
        }
    }

    @Override
    public void plusVolume() {
        device.setVolume(1);
    }

    @Override
    public void minusVolume() {
        device.setVolume(-1);
    }

    @Override
    public void prevChannel() {
        device.setChannel(-1);
    }

    @Override
    public void nextChannel() {
        device.setChannel(1);
    }


    @Override
    public void selectChannel(int channel) {
        device.setChannel(channel);
    }

    @Override
    public void info() {
        device.printInfo();
    }


}
