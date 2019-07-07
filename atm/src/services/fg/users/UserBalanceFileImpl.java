package services.fg.users;

import app.Context;
import exceptions.AuthException;
import exceptions.UserRepositoryException;
import models.Users;
import services.da.user.UserRepository;

public class UserBalanceFileImpl implements UsersBalance {

    UserRepository repository;

    @Override
    public double balance() throws UserRepositoryException{
        Users user = repository.get(Context.authUserId);
        if (user == null){
            throw new UserRepositoryException("Пользователь не найден");
        }

        return user.getAmount();

    }
}
