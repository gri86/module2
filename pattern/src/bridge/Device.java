package bridge;

/**
 * Телек, радио
 */

public interface Device {

    public void on();
    public void off();
    public boolean isEnabled();
    public void setVolume(int volume);
    public void setChannel(int channel);
    public void printInfo();

}
