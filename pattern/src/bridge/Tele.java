package bridge;

abstract class Tele implements Device {
    protected int volume;
    protected int channel;
    protected boolean power;
    protected String name;

    public Tele(String name) {
        this.name = name;
        this.volume = 30;
        this.channel = 1;
        this.power = false;
    }

    @Override
    public void on() {
        this.power = true;
    }

    @Override
    public void off() {
        this.power = false;
    }

    @Override
    public boolean isEnabled() {
        return this.power;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = this.volume + volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = this.channel + channel;
    }
}
