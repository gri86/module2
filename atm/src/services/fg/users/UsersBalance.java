package services.fg.users;

import exceptions.UserRepositoryException;

public interface UsersBalance {
    double balance() throws UserRepositoryException;
}
