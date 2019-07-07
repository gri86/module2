package home.decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
