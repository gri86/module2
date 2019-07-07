package services.cg.users;

import models.Users;

public interface UserService {
    boolean transfer(Users to, double amount);
    boolean withdraw(double amount);
    boolean deposit(double amount);
    void balance();
}
