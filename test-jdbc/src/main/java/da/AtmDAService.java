package da;

import entity.Atm;

import java.util.List;

public interface AtmDAService {
    public List<Atm> get();
    public Atm get(String id);
    public void insert(Atm item);
    public void delete(String id);
    public void update(Atm item);
}
