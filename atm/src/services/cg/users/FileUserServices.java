package services.cg.users;

import exceptions.UserRepositoryException;
import exceptions.UserServiceException;
import models.Users;
import services.fg.logger.Logger;
import services.fg.users.UsersBalance;

public class FileUserServices implements UserService {

    private UsersBalance service;
    private Logger logger;

    @Override
    public boolean transfer(Users to, double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        try {
            double balance = service.balance();
            if ((balance - amount) < 0){
                throw new UserServiceException("Не достаточно средств на счете");
            }

        } catch (UserRepositoryException e) {
            logger.log("Ошибка списания средств: "+e.getMessage());
        } catch (UserServiceException ex){
            logger.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        return false;
    }

    @Override
    public void balance() {
        try {
            System.out.println("Сумма на вашем счете равна: "+ service.balance()+"p.");
        } catch (UserRepositoryException e) {
            logger.log("Ошибка получения баланса: "+e.getMessage());
        }
    }
}
