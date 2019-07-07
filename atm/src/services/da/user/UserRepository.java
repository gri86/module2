package services.da.user;

import models.Users;

import java.util.List;

public interface UserRepository {
    Users get(int id);
    List<Users> get();
    boolean add(Users user);
    boolean delete(int id);
    boolean update(Users user);
}
