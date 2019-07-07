package bridge;

public interface Remote {
    /**
     * Turn on or trun off device
     */
    public void power();

    public void plusVolume();

    public void minusVolume();

    public void prevChannel();

    public void nextChannel();

    public void selectChannel(int channel);

    public void info();

}
