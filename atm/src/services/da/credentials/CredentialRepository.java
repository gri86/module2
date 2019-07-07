package services.da.credentials;

import models.Credentials;

import java.util.List;

public interface CredentialRepository {
    Credentials get(int id);
    List<Credentials> get();
    boolean add(Credentials credentials);
    boolean delete(int id);
    boolean update(Credentials credentials);
}
